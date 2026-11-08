from ai import *
from stt import *
from vision import *
import threading
import ctypes

needs_more = 1

def stt_to_ai(text:str):
    global emotion_val
    response = send_message(f'[compare] [{emotion_val.raw.rstrip(b'\x00')}] {text}')
    print(response)
    if '[bad]' in response:
        speak(response.partition(' ')[-1])
    if '[needs_more]' in response:
        needs_more += 1
    


if __name__ == "__main__":
    tts_init()

    stt_bit = stt_init(stt_to_ai)

    emotion_val = multiprocessing.Array('c', 32)
    p = multiprocessing.Process(target=recognizer_thread, args=(emotion_val, ), daemon=True)
    p.start()
   
    initial_response = ai_init()
    print(initial_response)
    topics = initial_response.partition(' ')[-1].split(',')
    for i, topic in enumerate(topics):
        print(f"{i + 1}. {topic}")
    print(send_message(f'[topic], {topics[int(input('Choose a topic: ')) - 1]}'))
    needs_more = 2
    while True:        
        while needs_more > 0:
            print('new speech: ',send_message('[speech]'))
            needs_more -= 1
        stt_bit.get_text()
