// require Discord.js
const Discord = require('discord.js');

// create the client and login
const client = new Discord.Client();
client.login('your-super-secret-token');

// ready event
client.on('ready', () => console.log('I am ready!'));

// message event
client.on('message', (msg) => {
    // if the author is a bot, ignore the message
    if (msg.author.bot) return;

    // if the message's content is "ping"
    if (msg.content === 'ping') {
        // send a message saying "pong!"
        return msg.channel.send('pong!');
    }
});
