package fr.matthieu42.lightshotbot;

import fr.matthieu42.lightshotbot.event.MessageListener;
import fr.matthieu42.lightshotbot.command.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LightShotBot {
    public static void main(String[] args) throws IOException {
        try
        {
            Commands commandsList = new Commands();
            commandsList.addCommands(new HelpCommand(commandsList),new SpamImage()
            );
            JDA bot = new JDABuilder(AccountType.BOT).setToken(new String(Files.readAllBytes(Paths.get("./resources/text/token.txt")))).setGame(Game.of(Game.GameType.DEFAULT,"Ramasse les gros sous")).buildAsync();
            bot.addEventListener(new MessageListener(commandsList));
        } catch (LoginException e)
        {
            e.printStackTrace();
        }
    }

}
