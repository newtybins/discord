const Eris = require('eris');

// Create an instance of the bot!
const bot = new Eris('your-super-secret-token');

// When I am ready, inform the developer through the logs!
bot.on('ready', () => console.log('I am ready!'));

// When a message is sent to a channel - and if the content of
// the message is ping, reply with pong!
bot.on('messageCreate', msg => {
    if (msg.content === 'ping') {
        bot.createMessage(msg.channel.id, 'pong!');
    }
});