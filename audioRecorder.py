import sounddevice as sd
from scipy.io.wavfile import write
from base64 import b64encode
from pydub import AudioSegment
from os.path import splitext

import audiotools


fs = 44100  # Sample rate
seconds = 0  # Duration of recording

secondsFile = open("seconds.txt", "r")
b64bFile = open("b64.txt", "wb")

tempSeconds = secondsFile.read(5)

if tempSeconds == None:
    seconds = 3
    print("hello")
else:
    seconds = int(tempSeconds)

print("recording..")
myrecording = sd.rec(int(seconds * fs), samplerate=fs, channels=2)
sd.wait()  # Wait until recording is finished
print("recording finished")
print("writing to file")

write('output.wav', fs, myrecording)  # Save as WAV file



wavFile = open("output.wav", "rb")

flac_path = splitext("output.wav")[0] + ".flac"
audio = AudioSegment.from_wav("output.wav")
audio.export(flac_path , format = 'flac')


encodedText = b64encode(wavFile.read())
b64bFile.write(encodedText)
