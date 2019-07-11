import random
import speech_recognition as sr
import pyttsx

r = sr.Recognizer()
r.energy_Threshold = 10000

dialogue = ""

while(True):
    str = input("type 1 to talk\n>: ")
    if(int(str) == 1):
        with sr.Microphone() as source:
            print('Say Something')
            r.adjust_for_ambient_noise(source, duration = 1)
            audio = r.listen(source)

            try:
                dialogue = r.recognize_google(audio)
            except:
                print("sorry I didn't catch that")

        print("DIALOGUE " + dialogue)

        knowledgeFile = open("knowledge.txt", "r")
        fileString = knowledgeFile.read()
        arrayOfStrings = fileString.split("\n")

        actualResponse = "I'm sorry i don't understand"

        for lineNum in range(0,len(arrayOfStrings)):
            if "K:" in arrayOfStrings[lineNum]:
                splitUpKeyWords = arrayOfStrings[lineNum][2:].split(",")
                splitUpKeyWords.remove(splitUpKeyWords[len(splitUpKeyWords)-1])

                for keyword in splitUpKeyWords:
                    if keyword in dialogue:
                        if "K:" in arrayOfStrings[lineNum]:
                            lineNum += 1
                        splitUpResponses = arrayOfStrings[lineNum][2:].split(",")
                        #splitUpResponses.remove(splitUpResponses[len(splitUpResponses)-1])
                        actualResponse = splitUpResponses[random.randint(1, len(splitUpResponses)-1)]

        print("RESPONSE " + actualResponse)
        engine = pyttsx.init()
        engine.say(actualResponse)
        engine.runAndWait()
    else:
        break;
