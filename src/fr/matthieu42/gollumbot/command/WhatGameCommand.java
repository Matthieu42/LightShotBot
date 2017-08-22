package fr.matthieu42.gollumbot.command;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class WhatGameCommand extends Command {
    public WhatGameCommand() {
        super("!queljeu", "Choisis aléatoirement un jeu à jouer suivant le nb de joueurs (2,3,4 ou + ) ou parmis tout les jeux si sans arguments");
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        TextChannel currentChannel = event.getTextChannel();
        String command = event.getMessage().getContent().replaceFirst("!queljeu ", "");
        int nbPlayer;
        try {
            nbPlayer = Integer.parseInt(command);
        }
        catch (NumberFormatException e) {
            if(command.equals("+"))
                nbPlayer = 5;
            else
                nbPlayer = 0;
        }
        try {
            String games2 = new String(Files.readAllBytes(Paths.get("./resources/text/games2.txt")));
            String games3 = new String(Files.readAllBytes(Paths.get("./resources/text/games3.txt")));
            String games4 = new String(Files.readAllBytes(Paths.get("./resources/text/games4.txt")));
            String games5 = new String(Files.readAllBytes(Paths.get("./resources/text/games5.txt")));
            String[] games2List = games2.split("\n");
            String[] games3List = games3.split("\n");
            String[] games4List = games4.split("\n");
            String[] games5List = games5.split("\n");
            String[] games45List = ArrayUtils.addAll(games4List, games5List);
            String[] games345List = ArrayUtils.addAll(games45List, games3List);
            String[] games2345List = ArrayUtils.addAll(games345List, games2List);
            String[][] gamesList = new String[6][];
            gamesList[0] = games2345List;
            gamesList[3] = games345List;
            gamesList[4] = games45List;
            gamesList[5] = games5List;

            Random random = new Random();
            currentChannel.sendMessage("Vous pouvez jouer à " + gamesList[nbPlayer][random.nextInt(gamesList[nbPlayer].length)] + " bande de hobbits jouflus").complete();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
