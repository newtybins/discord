import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;

public class Main {
    public static void main(String[] args) {
        final DiscordClient client = DiscordClient.create("your-super-secret-token");
        final GatewayDiscordClient gateway = client.login().block();

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();

            if (message.getContent().equals("ping")) {
                message.getChannel().block().createMessage("pong!").block();
            }
        });

        gateway.onDisconnect().block();
    }
}
