def get_colors_list():
    colors = {}
    colors["black"] = (0,0,0)
    colors["white"] = (255,255,255)
    colors["grey"] = (128,128,128)
    colors["silver"] = (192,192,192)
    colors["maroon"] = (128,0,0)
    colors["red"] = (255,0,0)
    colors["olive"] = (128,128,0)
    colors["yellow"] = (255,255,0)
    colors["green"] = (0,255,0)
    colors["dark_green"] = (0,128,0)
    colors["teal"] = (0,128,128)
    colors["aqua"] = (0,255,255)
    colors["navy"] =  (0,0,128)
    colors["blue"] = (0,0,255)
    colors["purple"] = (128,0,128)
    colors["fuchsia"] = (255,0,255)
    return colors
import numpy as np
import cv2
green = np.uint8([[[128/4,3*128/4,0]]])
hsv_green = cv2.cvtColor(green,cv2.COLOR_BGR2HSV)
print hsv_green

def near(p1,p2):
    return abs(p1[0] - p2[0]) <= 1 and abs(p1[1] - p2[1]) <= 1

class Body:
    def __init__(self):
        list = []
    def __contains__(self, point):
        return point in self.list
    def is_near(self, point):
        return any(near(i,point) for i in self.list)
    def add_if_able(self, point):
        if self.is_near(point):
            self.list.append(point)
            return True
        return False
    def area(self):
        return len(self.list)

