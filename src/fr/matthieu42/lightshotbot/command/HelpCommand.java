package fr.matthieu42.lightshotbot.command;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import java.awt.*;

public class HelpCommand extends Command{


    private Commands commands;

    public HelpCommand(Commands commands) {
        super("!aide", "Affiche l'aide du bot");
        this.commands = commands;
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        TextChannel currentChannel = event.getTextChannel();
        User botUser = event.getJDA().getSelfUser();
        EmbedBuilder help = new EmbedBuilder();
        help.setAuthor(botUser.getName(),"http://matthieu42.fr",botUser.getAvatarUrl());
        help.setTitle("Les différentes commandes");
        for(Command c : commands.getCommandList()){
            help.addField("```" + c.getName() + "```",c.getDescription(),false);
        }
        help.setColor(Color.BLUE);
        currentChannel.sendMessage(help.build()).complete();
    }
}
