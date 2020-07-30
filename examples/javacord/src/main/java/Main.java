import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the bot!
        DiscordApi api = new DiscordApiBuilder().setToken("your-super-secret-token").login().join();

        // When a message is sent to a channel - and if the content of
        // the message is ping, reply with pong!
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("ping")) {
                event.getChannel().sendMessage("pong!");
            }
        });
    }
}
