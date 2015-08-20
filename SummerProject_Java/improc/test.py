import cv2
import numpy as np

cap = cv2.VideoCapture(0)
_, im = cap.read()
cv2.imwrite("image.png", im)
while(1): #change to if for camera
    
    # Take each frame
    #_, im = cap.read()
    
    
    n = 5
    kernel = np.ones((n,n),np.float32)/(n*n)
    im = cv2.filter2D(im,-1,kernel)

    grey = cv2.cvtColor(im,cv2.COLOR_BGR2GRAY)
    
    
    k = cv2.waitKey(5) & 0xFF
    cv2.imshow("tote.jpg",im)
    ret,thresh = cv2.threshold(grey,127,255,0)
    
    img, contours, hierarchy = cv2.findContours(thresh,cv2.RETR_TREE,cv2.CHAIN_APPROX_SIMPLE)
    img = cv2.drawContours(img, contours, 3, (0,255,0), 3)
    cv2.imshow("image",img)
    
    if k == 27:
        break

cv2.destroyAllWindows()