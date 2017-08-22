package fr.matthieu42.gollumbot.command;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import fr.matthieu42.gollumbot.music.MusicManager;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ShowQueueCommand extends MusicCommand{

    public ShowQueueCommand(MusicManager manager) {
        super("!list", "Montrer file d'attente",manager);
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        StringBuilder queue = new StringBuilder();
        for(AudioTrack t : manager.getPlayer(event.getGuild()).getListener().getTracks()) {
            queue.append(t.getInfo().title);
            queue.append("\n");
        }
        if(!queue.toString().isEmpty())
            event.getTextChannel().sendMessage(queue.toString()).complete();
        else
            event.getTextChannel().sendMessage("Encore aucune piste à suivre... J'attends vos ordres Maître !").complete();
    }
}
