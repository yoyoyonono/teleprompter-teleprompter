import subprocess

assert subprocess.run(['espeak', 'online']).returncode == 0

def speak(sentence: str):
    subprocess.run(['espeak', sentence])

