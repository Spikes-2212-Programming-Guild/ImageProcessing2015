import cv2
import numpy as np

cap = cv2.VideoCapture(0)
while(1): #change to if for camera
    
    # Take each frame
    _, im = cap.read()
    
    im = cv2.cvtColor(im,cv2.COLOR_RGB2HSV)
    
    k = cv2.waitKey(5) & 0xFF
    cv2.imshow("image",im)
    
    if k == 27:
        break

cv2.destroyAllWindows()