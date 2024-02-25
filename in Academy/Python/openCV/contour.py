import cv2 as cv

# 컨투어란??
# 특정 영역의 경계를 따라 같은 픽셀 강도를 가진 선을 연결하는 것

img_color = cv.imread('test.jpg')
img_gray = cv.cvtColor(img_color,cv.COLOR_BGR2GRAY)

# img 이진화
ret , img_binary = cv.threshold(img_gray, 127, 255, 0)

# contour Approximation Method
# - cv.CHAIN_APPROX_NONE : 모든 경계점을 저장
# - cv.CHAIN_APPROX_SIMPLE : 컨투어를 구성하는거가 직선일 경우 이것의 시작점과 끝 점만 저장
##################################
# contour Retrieval Mode
# - cv.RETR_TREE : 컨투어 내부에 다른 컨투어가 있을 경우 계층 구주로 만들어 준다. [next , prev , first_child , parent ]
# - cv.RETR_LIST : 모든 컨투어가 같은 계층 레벨을 가진다. [next, previous , first_child , parent] : first_child , parent가 모두 -1
# - cv.RETR_EXTERNAL : 가장 외각에 있는 컨투어만 리턴 된다.
# - cv.RETR_CCOMP : ??
contours, hierarchy = cv.findContours(img_binary,cv.RETR_LIST,cv.CHAIN_APPROX_NONE)

image = cv.drawContours(img_color,contours,-1,(255,0,0),3)

cv.imshow('result',img_color)
cv.waitKey(0)



