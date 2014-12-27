# http://docs.opencv.org/trunk/doc/py_tutorials/py_gui/py_drawing_functions/py_drawing_functions.html

#Drawing Functions
import numpy as np
import cv2

# Create a black image
img = np.zeros((250,250,3), np.uint8)
print img

# Draw a diagonal blue line with thickness of 5 px
#cv2.line(img,(0,0),(511,511),(255,0,0),5)

#scv2.rectangle(img,(384,0),(510,128),(0,255,0),3)

#cv2.circle(img,(447,63), 63, (0,0,255), -1)
#cv2.ellipse(img,(256,256),(100,50),0,0,180,255,-1)

pts = np.array([[10,5],[20,30],[50,10]], np.int32)
pts = pts.reshape((-1,1,2))
cv2.polylines(img,[pts],True,(0,255,255))

cv2.imshow('image',img)
cv2.waitKey(0)
cv2.destroyAllWindows()
