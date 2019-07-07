import speech_recognition as sr
import pyttsx

r = sr.Recognizer()
r.energy_Threshold = 1000

#for index, name in enumerate(sr.Microphone.list_microphone_names()):
#    print("Microphone with name \"{1}\" found for `Microphone(device_index={0})`".format(index, name))
    #7 was weird 15, 18 was bust
with sr.Microphone() as source:
    print('Say Something')
    r.adjust_for_ambient_noise(source, duration = 1)
    audio = r.listen(source)

    try:
        text = r.recognize_google(audio)
        print('I think you said: '+ text)
    except:
        print("sorry I didn't catch that")


engine = pyttsx.init()
engine.say(text)
engine.runAndWait()
