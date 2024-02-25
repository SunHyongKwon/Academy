from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from bs4 import BeautifulSoup
import urllib.request as req
import pandas as pd
import time
import sys
import multiprocessing as mp
import os
from multiprocessing import Pool
import re
from urllib import parse


def get_data(start,end,len):
    chrom_options = webdriver.ChromeOptions()
    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()),options=chrom_options)
    driver.get('https://gajok.kr/sub/store.php')

    time.sleep(20)

    names = []
    addresses = []
    phones = []
    images = []

    for i in range(start,end):
        try:
            xpath = f'//*[@id="result_store"]/div[1]/ol/li[{i}]/a'
            driver.find_element(By.XPATH,xpath).click()

            time.sleep(1)

            xpath = f'//*[@id="map"]/div[1]/div/div[6]/div[{len}]/div/div[2]/a'
            driver.find_element(By.XPATH,xpath).click()

            time.sleep(1)

            # 텍스트 정보 가져오기
            # selenium에서 Beautiful soup 이용해서 텍스트 정보 가져오기 
            html = driver.page_source
            soup = BeautifulSoup(html, 'html.parser') 

            # 가게 이름
            names.append(soup.select_one('h4').text)
            print("가게이름 : ",soup.select_one('h4').text)
            
            # 주소
            address = soup.select_one('div.info li')
            addresses.append(address.text.replace('매장주소',''))
            print("가게주소 : ",address.text.replace('매장주소',''))

            # 전화번호
            phone=soup.select_one('div.info a')
            phones.append(phone.text)
            print("가게번호 : ",phone.text)
            

            # 이미지 저장하기
            image = driver.find_element(By.XPATH,'//*[@id="detail"]/div/div/div/div[1]/div')
            url='https://gajok.kr'+image.get_attribute('style').split(';')[0][23:-2]
            
            # 공백 %20 바꾸기
            url=url.replace(' ','%20')

            # 한글 찾기
            url_ko=re.compile('[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+').findall(url)
            
            if not url_ko is None:
                for ko in url_ko:
                    enc_ko=parse.quote(ko)
                    url=url.replace(ko,enc_ko)

            images.append(url)
            print("이미지이 : ",url)

            saveName = f"./Image/{i}.jpg"
            req.urlretrieve(url, saveName)


            xpath = '//*[@id="detail"]/div/div/a'
            driver.find_element(By.XPATH,xpath).click()
            time.sleep(1)

        except:
            print('error')
    
    return (names, addresses , phones , images)

if __name__ == "__main__":
    # recursionlimit 늘려주기
    sys.setrecursionlimit(10000)

    p = Pool(6)
    
    # 가게 몇 개인지 판단하기 위해서 
    url='https://gajok.kr/sub/store.php'

    res = req.urlopen(url)

    soup = BeautifulSoup(res,"html.parser")

    shops = soup.select('dt')


    shops = [shop.text for shop in shops]
    shops.remove('')

    # multi processing
    ret1 = p.apply_async(get_data,(1,100,len(shops)+1))
    ret2 = p.apply_async(get_data,(100,200,len(shops)+1))
    ret3 = p.apply_async(get_data,(200,250,len(shops)+1))
    ret4 = p.apply_async(get_data,(350,len(shops)+1,len(shops)+1))
    ret5 = p.apply_async(get_data,(250,300,len(shops)+1))
    ret6 = p.apply_async(get_data,(300,350,len(shops)+1))

    names = ret1.get()[0]+ret2.get()[0]+ret3.get()[0]+ret4.get()[0]+ret5.get()[0]+ret6.get()[0]
    addresses = ret1.get()[1]+ret2.get()[1]+ret3.get()[1]+ret4.get()[1]+ret5.get()[1]+ret6.get()[1]
    phones = ret1.get()[2]+ret2.get()[2]+ret3.get()[2]+ret4.get()[2]+ret5.get()[2]+ret6.get()[2]
    images = ret1.get()[3]+ret2.get()[3]+ret3.get()[3]+ret4.get()[3]+ret5.get()[3]+ret6.get()[3]
    
    df=pd.DataFrame(data=zip(names,addresses,phones,images), columns=['Name','Address','Phone','Image'])
    df.to_csv('./Data/gajok2.csv',encoding='utf-8',index=False)

    p.close()
    p.join()