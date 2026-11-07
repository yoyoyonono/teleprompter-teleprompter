import subprocess

assert subprocess.run(['espeak-ng', 'online']).returncode == 0

def speak(sentence: str):
    subprocess.run(['espeak-ng', sentence])

