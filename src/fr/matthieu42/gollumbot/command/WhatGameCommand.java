package fr.matthieu42.gollumbot.command;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class WhatGameCommand extends Command {
    public WhatGameCommand() {
        super("!queljeu", "Choisis aléatoirement un jeu à jouer suivant le nb de joueurs (2,3,4 ou + ) ou parmis tout les jeux si sans arguments");
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        TextChannel currentChannel = event.getTextChannel();
        String command = event.getMessage().getContentRaw().replaceFirst("!queljeu ", "");
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
            String[] games2List = new String(Files.readAllBytes(Paths.get("./resources/text/games2.txt"))).split("\n");
            String[] games3List = new String(Files.readAllBytes(Paths.get("./resources/text/games3.txt"))).split("\n");
            String[] games4List = new String(Files.readAllBytes(Paths.get("./resources/text/games4.txt"))).split("\n");
            String[] games5List = new String(Files.readAllBytes(Paths.get("./resources/text/games5.txt"))).split("\n");
            String[] games45List = Stream.concat(Arrays.stream(games4List), Arrays.stream(games5List)).toArray(String[]::new);
            String[] games345List = Stream.concat(Arrays.stream(games45List), Arrays.stream(games3List)).toArray(String[]::new);
            String[] games2345List = Stream.concat(Arrays.stream(games345List), Arrays.stream(games2List)).toArray(String[]::new);
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
