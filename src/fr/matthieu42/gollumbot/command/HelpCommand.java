package fr.matthieu42.gollumbot.command;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import java.awt.*;

public class HelpCommand extends Command{


    public HelpCommand() {
        super("!aide", "Affiche l'aide du bot");
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        TextChannel currentChannel = event.getTextChannel();
        User botUser = event.getJDA().getSelfUser();
        EmbedBuilder help = new EmbedBuilder();
        help.setAuthor(botUser.getName(),"http://matthieu42.fr",botUser.getAvatarUrl());
        help.setTitle("Les différentes commandes");
        help.addField("```!aide```",new HelpCommand().getDescription(),false);
        help.addField("```!play \"lien youtube\"```",new PlayCommand(null).getDescription(),false);
        help.addField("```!skip```",new SkipCommand(null).getDescription(),false);
        help.addField("```!clear```",new ClearCommand(null).getDescription(),false);
        help.addField("```!liste```",new ShowQueueCommand(null).getDescription(),false);
        help.addField("```!queljeu```",new WhatGameCommand().getDescription(),false);
        help.setColor(Color.BLUE);
        currentChannel.sendMessage(help.build()).complete();
    }
}
