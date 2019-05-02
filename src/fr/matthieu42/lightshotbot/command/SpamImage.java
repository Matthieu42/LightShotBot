package fr.matthieu42.lightshotbot.command;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.math.BigInteger;

public class SpamImage extends Command {

    public SpamImage() {
        super("SpamImage","Spam des images random de lightshot");
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equals("!SpamImage")) {
            TextChannel textChannel = event.getTextChannel();
            textChannel.sendMessage("Indique les 6 lettres de l'URL à laquelle tu veux commencer fdp").complete();
        }

        String valueDepart = event.getMessage().getContentRaw().replaceFirst("!SpamImage ","");

        TextChannel textChannel = event.getTextChannel();
        BigInteger d = BigInteger.valueOf(Integer.parseInt(valueDepart,36));
        Boolean run = true;
        while(run){
            d = d.add(BigInteger.valueOf(1));
            String message = "https://prnt.sc/" +  Integer.toString(Integer.parseInt(d.toString()),36);
            textChannel.sendMessage(message).complete();
            System.out.println(message);
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
