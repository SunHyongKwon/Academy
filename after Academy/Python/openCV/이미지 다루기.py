import cv2

img_color = cv2.imread('test.jpg',cv2.IMREAD_COLOR)

cv2.namedWindow('img_color')
cv2.imshow('img_color',img_color)
 
cv2.waitKey(0)
cv2.destroyAllWindows()


