import cv2
import numpy as np
import time

n = 1
while True:
    im = cv2.imread("tote2.jpg")

    kernel = np.ones((n,n),np.float32)/(n*n)
    im = cv2.filter2D(im,-1,kernel)

    hsv = cv2.cvtColor(im, cv2.COLOR_BGR2HSV)
    h = 50
    low = np.array([h-10,30,30])
    high = np.array([h+10,255,255])
    
    # Threshold the HSV image to get only blue colors
    mask = cv2.inRange(hsv, low, high)
    #print (mask[0])
    # Bitwise-AND mask and original image
    
    #imgray = cv2.cvtColor(im,cv2.COLOR_BGR2GRAY)
    ret,thresh = cv2.threshold(mask,255,255,255) #originally: 127,255,0
    image, contours, hierarchy = cv2.findContours(thresh,cv2.RETR_TREE,cv2.CHAIN_APPROX_NONE)
    
    
    max_index = max(range(0,len(contours)), key=lambda i: cv2.contourArea(contours[i]))
    x,y,w,h = cv2.boundingRect(contours[max_index])
    
    
    #im = mask
    im = cv2.rectangle(im,(x,y),(x+w,y+h),(0,0,255),4)
    
    im = cv2.resize(im, (840, 640))
    cv2.putText(im,str(n), (150,150), cv2.FONT_HERSHEY_COMPLEX, 5, 500, thickness=5)
    cv2.imshow("foo",im)
    k = cv2.waitKey(5 if n % 5 == 0 else 1)
    if k == 27:
        break
    n = n+1
    n %= 250
    if n == 0:
        n = 1