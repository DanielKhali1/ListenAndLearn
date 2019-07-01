import sounddevice as sd
from scipy.io.wavfile import write

fs = 44100  # Sample rate
seconds = 0  # Duration of recording

secondsFile = open("seconds.txt", "r")
updaterFile = open("updater.txt", "wb")

tempSeconds = secondsFile.read(5)

if tempSeconds == None:
    seconds = 3
    print("hello")
else:
    seconds = int(tempSeconds)

print("recording..")
updaterFile.write("recording".encode())
myrecording = sd.rec(int(seconds * fs), samplerate=fs, channels=2)
sd.wait()  # Wait until recording is finished
updaterFile = open("updater.txt", "wb")
updaterFile.write("writing to file".encode())
print("recording finished")
print("writing to file")

write('output.wav', fs, myrecording)  # Save as WAV file
updaterFile = open("updater.txt", "wb")
updaterFile.write("Idle".encode())
