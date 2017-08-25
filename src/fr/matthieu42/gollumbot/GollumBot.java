package fr.matthieu42.gollumbot;

import fr.matthieu42.gollumbot.event.MessageListener;
import fr.matthieu42.gollumbot.command.*;
import fr.matthieu42.gollumbot.dialog.MentionHandler;
import fr.matthieu42.gollumbot.music.MusicManager;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class GollumBot {
    public static void main(String[] args){
        try
        {
            Commands commandsList = new Commands();
            MusicManager manager = new MusicManager();
            MentionHandler mentionHandler = new MentionHandler(manager);
            commandsList.addCommands(new HelpCommand(),
                    new PlayCommand(manager),
                    new ClearCommand(manager),
                    new SkipCommand(manager),
                    new ShowQueueCommand(manager),
                    new WhatGameCommand()
            );
            JDA bot = new JDABuilder(AccountType.BOT).setToken("MzQ4MDUwMzEwNDM1OTYyODkw.DHhSoA.dnTs5eyidhyvOd7iznMPh1EHjfI").setGame(Game.of("Protéger le précieux")).buildAsync();
            bot.addEventListener(new MessageListener(commandsList,mentionHandler));
        } catch (LoginException | RateLimitedException e)
        {
            e.printStackTrace();
        }
    }

}
