from RealtimeSTT import AudioToTextRecorder # https://github.com/KoljaB/RealtimeSTT
from tts import *
import pyaudio

class STTHandler:
    def __init__(self, text_callback):
        pa = pyaudio.PyAudio()
        for i in range(pa.get_device_count()):
            info = pa.get_device_info_by_index(i)
            if info['maxInputChannels'] > 0:
                print(f"[{i}] {info['name']}")
        self.recorder = AudioToTextRecorder()
        self.text_callback = text_callback

    def get_text(self):
        self.recorder.text(self.__on_text)

    def __on_text(self, text):
        print(f'Transcribed: {text}')
        self.text_callback(text)                


def print_text(text):
    print(text)

def stt_init(callback) -> AudioToTextRecorder:
    new_handler = STTHandler(callback)
    speak('STT online')
    return new_handler

