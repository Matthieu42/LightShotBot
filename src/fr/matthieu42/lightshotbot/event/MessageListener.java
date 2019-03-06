package fr.matthieu42.lightshotbot.event;

import fr.matthieu42.lightshotbot.command.Command;
import fr.matthieu42.lightshotbot.command.Commands;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    private final Commands commandsList;

    public MessageListener(Commands commandsList) {
        this.commandsList = commandsList;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().isBot() || event.getMessage().getContentRaw().isEmpty())
            return;
        String msg = event.getMessage().getContentRaw();
        TextChannel currentChannel = event.getTextChannel();
        if(msg.charAt(0) == '!'){
            Command command = commandsList.getCommand(msg.split("\\s+")[0]);
            if(command != null)
                commandsList.getCommand(msg.split("\\s+")[0]).execute(event);
            }

    }
}
