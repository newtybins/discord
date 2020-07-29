const Discord = require('discord.js');

// Create an instance of the bot!
const client = new Discord.Client();
client.login('your-super-secret-token');

// When I am ready, inform the developer through the logs!
client.on('ready', () => console.log('I am ready!'));

// When a message is sent to a channel - and if the content of
// the message is ping, reply with pong!
client.on('message', msg => {
  if (msg.content === 'ping') {
    return msg.channel.send('pong!');
  }
});
