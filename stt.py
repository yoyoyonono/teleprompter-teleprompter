from vosk import Model, KaldiRecognizer
import sounddevice as sd
import json
from tts import speak

MODEL_PATH = "vosk-model-small-en-us-0.15"

class STTHandler:
    def __init__(self, text_callback):
        self.model = Model(MODEL_PATH)
        self.rec = KaldiRecognizer(self.model, 16000)
        self.text_callback = text_callback

    def get_text(self):
        with sd.RawInputStream(samplerate=16000, blocksize=8000, dtype='int16', channels=1) as stream:
            while True:
                data, _ = stream.read(8000)
                if self.rec.AcceptWaveform(bytes(data)):
                    result = json.loads(self.rec.Result())
                    text = result.get("text", "").strip()
                    if text:
                        print(f'Transcribed: {text}')
                        self.text_callback(text)
                        return


def stt_init(callback) -> STTHandler:
    handler = STTHandler(callback)
    speak('STT online')
    return handler

