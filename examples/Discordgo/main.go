package main

// imports
import (
	"fmt"

	"github.com/bwmarrin/discordgo"
)

// declare variables
var (
	botID string
)

// main function
func main() {
	// create a new bot instance
	discord, err := discordgo.New("Bot " + "your-super-secret-token")
	errCheck("Error creating the discord session", err)

	// get the bot user
	user, err := discord.User("@me")
	errCheck("Error retrieving account", err)

	botID = user.ID

	// create ready event and register message event
	discord.AddHandler(func(discord *discordgo.Session, ready *discordgo.Ready) {
		fmt.Printf("I am ready!")
	})

	discord.AddHandler(onMessage)

	// open a connection to Discord
	err = discord.Open()
	errCheck("Error opening connection to Discord", err)
	defer discord.Close()

	// allow the function to idle
	<-make(chan struct{})
}

// message event
func onMessage(discord *discordgo.Session, msg *discordgo.MessageCreate) {
	// if the user is a bot, ignore the message
	if msg.Author.ID == botID || msg.Author.Bot {
		return
	}

	// if the message's content is "ping"
	if msg.Content == "ping" {
		// send a message that says "pong!"
		discord.ChannelMessageSend(msg.ChannelID, "pong!")
	}
}

// error checker function
func errCheck(msg string, err error) {
	if err != nil {
		fmt.Printf("%s: %+v", msg, err)
		panic(err)
	}
}
