import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the bot!
        final DiscordClient client = DiscordClient.create(args[0]);
        final GatewayDiscordClient gateway = client.login().block();

        // When a message is sent to a channel - and if the content of
        // the message is ping, reply with pong!
        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();

            if (message.getContent().equals("ping")) {
                message.getChannel().block().createMessage("pong!").block();
            }
        });

        gateway.onDisconnect().block();
    }
}
