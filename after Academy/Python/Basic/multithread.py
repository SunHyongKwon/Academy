# ---- Before
# total = 0
# for i in range(100000000):
#     total += i

# print(total)

# -- After
# 알아서 적절한 쓰레드의 개수를 맞춰서 실행해준다.
from threading import Thread

def calc(start,end):
    total = 0
    for i in range(start, end):
        total += i
    print(total)     

if __name__ == "__main__":
    start , end = 0 , 100000000
    thr1 = Thread(target=calc, args=(start,end))

    thr1.start()
    thr1.join() # flutter의 await와 같은 개념
