import cv2
import numpy as np

cap = cv2.VideoCapture(0)

_, im = cap.read() 
blur_value = 0
if blur_value != 0:
    kernel = np.ones((blur_value,blur_value),np.float32)/(blur_value*blur_value)
    im = cv2.filter2D(im,-1,kernel)

hsv = cv2.cvtColor(im, cv2.COLOR_BGR2HSV)
h = 70
low = np.array([h-10,30,30])
high = np.array([h+10,255,255])

# Threshold the HSV image to get only blue colors
mask = cv2.inRange(hsv, low, high)

#imgray = cv2.cvtColor(im,cv2.COLOR_BGR2GRAY)

'''
the main difference between everything we did so far and this code lies withing the following line
the difference is that we use mask instead of the original pic
'''
ret,thresh = cv2.threshold(mask,255,255,255) #originally: 127,255,0
image, contours, hierarchy = cv2.findContours(thresh,cv2.RETR_TREE,cv2.CHAIN_APPROX_NONE)


max_index = max(range(0,len(contours)), key=lambda i: cv2.contourArea(contours[i]))
x,y,w,h = cv2.boundingRect(contours[max_index])

print str([x,y,w,h])

#im = mask
im = cv2.rectangle(im,(x,y),(x+w,y+h),(0,0,255),10)

im = cv2.resize(im, (840, 640))
cv2.imshow("foo",im)
k = cv2.waitKey(0)