package fr.matthieu42.gollumbot.event;

import fr.matthieu42.gollumbot.command.Command;
import fr.matthieu42.gollumbot.command.Commands;
import fr.matthieu42.gollumbot.dialog.MentionHandler;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    private final Commands commandsList;
    private final MentionHandler mentionHandler;

    public MessageListener(Commands commandsList, MentionHandler mentionHandler) {
        this.commandsList = commandsList;
        this.mentionHandler = mentionHandler;
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
        else if(event.getMessage().isMentioned(event.getJDA().getSelfUser())){
            mentionHandler.handle(event);
        }
        else {
            if (msg.contains("pagne")) {
                currentChannel.sendMessage("https://www.3dtotal.com/admin/new_cropper/tutorial_content_images/506_tid_pagnetext3dt.jpg").complete();
            }
            if (msg.contains("précieux")) {
                currentChannel.sendMessage("Il est à moi !").complete();
            }
        }

    }
}
