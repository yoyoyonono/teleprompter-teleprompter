# based on the opencv example and also code from here
# https://github.com/manish-9245/Facial-Emotion-Recognition-using-OpenCV-and-Deepface/blob/main/emotion.py

import numpy as np
import cv2 as cv
from deepface import DeepFace
from tts import *
import multiprocessing
from multiprocessing import Value
import ctypes


cascade_path = cv.data.haarcascades + "haarcascade_frontalface_default.xml"
def recognizer_thread(emotion_val):
    face_cascade = cv.CascadeClassifier(cascade_path)

    cap = cv.VideoCapture(0)
    if not cap.isOpened():
        print("Cannot open camera")
        exit()

    speak('camera online')

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
            current_emotion: str = result[0]['dominant_emotion']

            with emotion_val.get_lock():
                emotion_val.raw = current_emotion.encode().ljust(32, b'\x00')

            cv.putText(frame, current_emotion, (50, 250), cv.FONT_HERSHEY_COMPLEX, 1.2, (255, 255, 255), 2)

        cv.imshow('frame', frame)

        if cv.waitKey(1) == ord('q'):
            break

    cap.release()
    cv.destroyAllWindows()
