use serenity::{
    model::{channel::Message, gateway::Ready},
    prelude::*,
};

struct Handler;

impl EventHandler for Handler {
    // create a handler for the 'message' event
    fn message(&self, ctx: Context, msg: Message) {
        if msg.content == "ping" {
            /*
                Sending a message can fail so log to stdout
                when an error occurs with a description of it.
            */
            if let Err(why) = msg.channel_id.say(&ctx.http, "Pong!") {
                println!("Error sending message: {:?}", why);
            }
        }
    }

    // create a handler for the 'ready' event
    fn ready(&self, _: Context, _ready: Ready) {
        println!("I am ready!")
    }
}

fn main() {
    // create an instance of the client
    let mut client = Client::new("your-super-secret-token", Handler).expect("Error creating client");

    // start the bot
    if let Err(why) = client.start() {
        println!("Client error: {:?}", why);
    }
}