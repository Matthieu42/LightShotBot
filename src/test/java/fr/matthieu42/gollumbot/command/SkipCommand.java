package fr.matthieu42.gollumbot.command;

import fr.matthieu42.gollumbot.music.MusicManager;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class SkipCommand extends MusicCommand {

    public SkipCommand(MusicManager manager) {
        super("!skip", "Passer la musique actuelle", manager);
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        Guild guild = event.getGuild();
        TextChannel textChannel = event.getTextChannel();
        if(!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()){
            textChannel.sendMessage("Encore aucune piste... J'attends vos ordres Maître !").queue();
            return;
        }

        manager.getPlayer(guild).skipTrack();
        textChannel.sendMessage("Vous avez décidé de passer cette piste, Maître !").queue();
    }
}
