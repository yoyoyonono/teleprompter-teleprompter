from pathlib import Path
from openai import AzureOpenAI # https://pypi.org/project/openai/
from tts import *

PATRIOTAI_KEY = Path('./.env/patriotai_key').read_text()

SYSTEM_PROMPT = """
You are a system which powers many facets of a speech practice tool. You will encounter various kinds of events which you will need to provide responses for.

The events will be marked with the first word in brackets like [this]:

The [topic] event means that a new speech will start soon with the specified topic. Just responed with [ok]

The [speech] event means that you need to generate one more sentence of the speech that is currently being given. At the beginning of the line, you should also note what facial expression the speaker should have ([happy] or [sad]). The program will request more lines of you as time goes on. Make sure they make sense as a speech if you stirng them together. The speech should stay relatively informal. Don't start like a super serious business speech. As the speech continues, the lines should get more difficult and unwieldy, as well as more humorous in an attempt to make the speaker mess up or break into laughter. Do not repeat lines. Don't try too hard to be funny though because it doesn't come off well. The best way to go is to start normally and then go completely off the rails. By off the rails I mean completely off the rails, conspiracy theories style of crazy person talk.

The [compare] event means that you need to look at the speech-to-text and expression of the person giving the speech and compare it to the speech you wrote. If the speaker did not make any mistakes, your response should just be [good]. If the speaker has made a mistake in any aspect, you should start the response line with [bad], and then give a fitting insult that is short, only 4 or 5 words.

This is going to be demonstrated at a university class so things can get funny but should stay appropriate.

If you understand these rules, respond with [ok] a space and a comma separated list of suggested seemingly normal topics with humorous potential, keep the topics to 1 or 2 words each.
"""

client = AzureOpenAI( # https://github.com/openai/openai-python#microsoft-azure-openai
    api_key = PATRIOTAI_KEY,
    api_version = "2024-02-01",
    azure_endpoint = "https://apim-n1ai-use-gmun1.azure-api.net/",
)

history = []

def send_message(text: str, tokens: int = 50):
    new_message = {"role": "user", "content": text}
    history.append(new_message)
    response = client.chat.completions.create(
        model="gpt-4o",
        messages=history,
        max_tokens = tokens,
    )
    history.append({"role": "assistant", "content": response.choices[0].message.content})
    return response

print(send_message(SYSTEM_PROMPT).choices[0].message.content)

while True:
    response = send_message(input('You: '), 100)
    response_text = response.choices[0].message.content
    print(response_text)
    if response_text.startswith('[bad]'):
        speak(response_text[5:])


