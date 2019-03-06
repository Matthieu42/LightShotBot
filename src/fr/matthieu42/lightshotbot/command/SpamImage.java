package fr.matthieu42.lightshotbot.command;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.math.BigInteger;

public class SpamImage extends Command {

    public SpamImage() {
        super("SpamImage","Spamme des images random de lightshot");
    }

    @Override
    public void execute(MessageReceivedEvent event) {

        TextChannel textChannel = event.getTextChannel();
        BigInteger d = BigInteger.valueOf(621937810);
        Boolean run = true;
        while(run){
            if(d.compareTo(BigInteger.valueOf(Long.parseLong("2176782335"))) > 0 )
                run = false;
            d = d.add(BigInteger.valueOf(1));
            String message = "https://prnt.sc/" +  Integer.toString(Integer.parseInt(d.toString()),36);
            textChannel.sendMessage(message).complete() ;
            System.out.println(message);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
