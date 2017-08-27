package fr.matthieu42.gollumbot.command;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.*;

public class WebToImageCommand extends  Command {
    public WebToImageCommand() {
        super("!screen", "Prend une capture d'écran d'un site web donné");
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        String website = event.getMessage().getContent().replaceFirst("!screen ","");
        String http = "http";
        if (!website.contains(http))
            website = http.concat(website);
        try{
            Runtime runtime = Runtime.getRuntime();
            String[] cmdArray = {"java","-jar", "Website-to-image.jar",website,"0","1000","1200"};
            Process process = runtime.exec(cmdArray);
            InputStream ins = process.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(ins));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
            event.getTextChannel().sendFile(new File("./cap.png"), new MessageBuilder().append("Voici le site demandé, maître").build()).complete();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
