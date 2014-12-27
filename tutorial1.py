# http://docs.opencv.org/trunk/doc/py_tutorials/py_gui/py_image_display/py_image_display.html#py-display-image

import cv2
import numpy as np
from matplotlib import pyplot as plt

# Load an color image in grayscale
img = cv2.imread('image5.jpg',0)

print img

cv2.imshow('image',img)
cv2.waitKey(0)
cv2.destroyAllWindows()

'''
cv2.waitKey() is a keyboard binding function.
Its argument is the time in milliseconds.
The function waits for specified milliseconds for any keyboard event.
If you press any key in that time, the program continues.
If 0 is passed, it waits indefinitely for a key stroke.
It can also be set to detect specific key strokes like,
if key a is pressed etc which we will discuss below.
'''

cv2.imwrite('test.png',img)

img = cv2.imread('messi5.jpg',0)
plt.imshow(img, cmap = 'gray')
plt.xticks([]), plt.yticks([])  # to hide tick values on X and Y axis
plt.show()
