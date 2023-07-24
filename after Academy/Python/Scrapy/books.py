from bs4 import BeautifulSoup
import urllib.request as req
import time
from multiprocessing import Process
from urllib import parse
import sys

def get_books(*books):
    for book in books:
        print(book.text)
    


if __name__ == "__main__":

    url = 'https://ko.wikisource.org/wiki/'
    auth = '저자'
    name = '윤동주'
    url = url + parse.quote(auth) + ':' + parse.quote(name)

    res = req.urlopen(url)

    soup = BeautifulSoup(res,"html.parser")

    books=soup.find_all('li')

    booksOne=books[1:30]
    booksTwo=books[30:60]
    booksThree=books[60:94]

    # recursionlimit 늘려주기
    sys.setrecursionlimit(5000)

    p0 = Process(target=get_books,args=booksOne)
    p1 = Process(target=get_books,args=booksTwo)
    p2 = Process(target=get_books,args=booksThree)

    # start로 각 프로세스로 시작합니다.(무작위 실행)
    p0.start();p1.start();p2.start()

    # 출력은 순서대로 하기
    p0.join();p1.join();p2.join()