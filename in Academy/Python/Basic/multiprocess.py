#-- Before
# import time
# now = time.time()

# total1 = total2 = total3 = 0

# for i in range(0,100000000):
#     total1+=i
# print(total1)

# for i in range(100000001,200000000):
#     total2+=i
# print(total2)

# for i in range(200000001,300000000):
#     total3+=i
# print(total3)

# end = time.time()

# print("time:",end-now)

# -- After
import time
from multiprocessing import Process

def start_get(*strs):
    str = ''
    for i in strs:
        str += i
    print(str)

if __name__ == "__main__":

    now=time.time()

    # Process를 생성합니다. 
    p0 = Process(target=start_get, args=(['a','a','a']))
    p1 = Process(target=start_get, args=(['b','b','b']))
    p2 = Process(target=start_get, args=(['c','c','c']))

    # start로 각 프로세스로 시작합니다.(무작위 실행)
    p0.start();p1.start();p2.start()

    # 출력은 순서대로 하기
    p0.join();p1.join();p2.join()

    end=time.time()

    print("time :",end - now)
