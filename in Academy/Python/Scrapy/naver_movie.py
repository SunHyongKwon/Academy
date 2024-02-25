from bs4 import BeautifulSoup
import urllib.request as req
import time
from multiprocessing import Pool
import multiprocessing as mp
import sys
import pandas as pd
import os

def get_movies(*movies):
    links = [movie.attrs['href'] for movie in movies]
    titles = [movie.text for movie in movies]
    return (links, titles)
    


if __name__ == "__main__":
    # recursionlimit 늘려주기
    sys.setrecursionlimit(10000)
    p = Pool(3)
    start = time.time()

    url='https://movie.naver.com/movie/sdb/rank/rmovie.naver'

    res = req.urlopen(url)
    soup = BeautifulSoup(res,"html.parser")

    titles = soup.select('.tit3 > a')

    titlesOne = titles[0:17]
    titlesTwo = titles[17:35]
    titlesThree = titles[35:50]

    ret1 = p.apply_async(get_movies,titlesOne)
    ret2 = p.apply_async(get_movies,titlesTwo)
    ret3 = p.apply_async(get_movies,titlesThree)

    print(ret1.get()[0],ret2.get()[0],ret3.get()[0])
    print(ret1.get()[1],ret2.get()[1],ret3.get()[1])

    print(len(ret1.get()[0]+ret2.get()[0]+ret3.get()[0]))
    delta_t = time.time()-start
    print("Time :",delta_t)

    p.close()
    p.join()

    # df=pd.DataFrame(data=zip(ranks,titles,links), columns=['Rank','Title','Link'])
    # df.to_csv('../Data/NaverList_multi.csv',encoding='utf-8',index=False)