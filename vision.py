# based on the opencv example and also code from here
# https://github.com/manish-9245/Facial-Emotion-Recognition-using-OpenCV-and-Deepface/blob/main/emotion.py

import numpy as np
import cv2 as cv
from deepface import DeepFace

cascade_path = cv.data.haarcascades + "haarcascade_frontalface_default.xml"
face_cascade = cv.CascadeClassifier(cascade_path)
 
cap = cv.VideoCapture(1)
if not cap.isOpened():
    print("Cannot open camera")
    exit()
while True:
    ret, frame = cap.read()
 
    if not ret:
        print("Can't receive frame (stream end?). Exiting ...")
        break
    gray = cv.cvtColor(frame, cv.COLOR_BGR2GRAY)

    faces = face_cascade.detectMultiScale(gray, scaleFactor=1.3, minNeighbors=5, minSize=(30, 30))

    for (x, y, w, h) in faces:
        cv.rectangle(frame, (x, y), (x + w, y + h), (255, 0, 0), 2)
        face_roi = frame[y:y + h, x:x + w]
        result = DeepFace.analyze(face_roi, actions=['emotion'], enforce_detection=False)
        emotion = result[0]['dominant_emotion']
        print(emotion)

    cv.imshow('frame', frame)

    if cv.waitKey(1) == ord('q'):
        break
 
cap.release()
cv.destroyAllWindows()