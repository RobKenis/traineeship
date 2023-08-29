import requests

URL = 'https://www.amazon.com/'
def handler(event, context):
    requests.get(URL)