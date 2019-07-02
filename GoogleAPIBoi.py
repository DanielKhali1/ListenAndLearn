import requests
from base64 import b64encode

wavFile = open("output.wav")
body = b64encode(wavFile.read())
wavFile.close()

API_ENDPOINT = ""
#need this
API_KEY = "XXXXXX"
data = {
    'api_dev_key' : API_KEY,
    'api_option' : 'paste',
    'api_paste_code':source_code,
    'api_paste_format' : 'python'
}
