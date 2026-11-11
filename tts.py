import subprocess

def tts_init():
    assert subprocess.run(['espeak-ng', 'tts online']).returncode == 0

def speak(sentence: str):
    subprocess.run(['espeak-ng', sentence])

