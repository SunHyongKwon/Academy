from bs4 import BeautifulSoup
import urllib.request as req
import time
from multiprocessing import Process

def find_news_data(links):
    for link in links:
        time.sleep(1)

        url = link.attrs['href']
        res = req.urlopen(url)

        soup = BeautifulSoup(res,"html.parser")
        reporter = soup.select_one('.txt_info').string.strip()
        date = soup.select_one('.num_date').string.strip()
        print(link.attrs['href'].ljust(45) ,link.string.strip().ljust(60),reporter.ljust(20),date.ljust(20))
    return None


if __name__ == "__main__":

    url = 'https://news.daum.net/digital#1'
    res = req.urlopen(url)

    soup = BeautifulSoup(res,"html.parser")
    links = soup.select('.link_txt')
    links1 = links[6:9]
    links2 = links[9:13]
    links3 = links[13:16]
    print('링크'.ljust(45),'제목'.ljust(70),'작성자'.ljust(20),'날짜'.ljust(20))

    p0 = Process(target=find_news_data, args=links1)
    p1 = Process(target=find_news_data, args=links2)
    p2 = Process(target=find_news_data, args=links3)

    # start로 각 프로세스로 시작합니다.(무작위 실행)
    p0.start();p1.start();p2.start()

    # 출력은 순서대로 하기
    p0.join();p1.join();p2.join()