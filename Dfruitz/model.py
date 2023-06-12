import cv2
import numpy as np
from tensorflow.keras.models import load_model

# Load the model
model = load_model('dfruitz_model_dropOut.h5')

# image read and return output
def tampilkan(path):
    x_test = []

    ini = cv2.resize(cv2.imread(path), (64, 64))/255
    x_test.append(ini)

    x_test = np.asarray(x_test)

    y_pred = model.predict(x_test)
    y_pred = np.argmax(y_pred, axis=1)

    kamus = {0: "Apple_Bad", 1: "Banana_Bad", 2: "Guava_Bad",3: "Lime_Bad", 4: "Orange_Bad", 5: "Pomegranate_Bad",
            6: "Apple_Good", 7: "Banana_Good", 8: "Guava_Good",9: "Lime_Good", 10: "Orange_Good", 11: "Pomegranate_Good",
            12: "Apple_Mixed", 13: "Banana_Mixed", 14: "Guava_Mixed",15: "Lime_Mixed", 16: "Orange_Mixed", 17: "Pomegranate_Mixed"}

    index = 0
    for _ in y_pred:
        index = _

    return kamus[index]