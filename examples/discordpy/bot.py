# import discord.py
import discord

client = discord.Client()

# ready event
@client.event
async def on_ready():
    print('I am ready!')

# message event
@client.event
async def on_message(msg):
    # if the message starts with "ping"
    if msg.content.startsWith('ping'):
        # send a message saying "pong!"
        await client.send_message(msg.channel, 'pong!')

client.run('your-super-secret-token')
