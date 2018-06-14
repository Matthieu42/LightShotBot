package fr.matthieu42.gollumbot.command;

import fr.matthieu42.gollumbot.music.MusicManager;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PlayCommand extends MusicCommand {

    public PlayCommand(MusicManager manager) {
        super("!play", "Lance une video youtube",manager);
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        Guild guild = event.getGuild();
        User user = event.getAuthor();
        TextChannel textChannel = event.getTextChannel();
        String command = event.getMessage().getContentRaw();

        if(guild == null) return;
        if(!guild.getAudioManager().isConnected() && !guild.getAudioManager().isAttemptingToConnect()){
            VoiceChannel voiceChannel = guild.getMember(user).getVoiceState().getChannel();
            if(voiceChannel == null){
                textChannel.sendMessage("Mais voyons mon précieux, Vous devez être connecté à un salon vocal pour écouter cette glorieuse musique.").queue();
                return;
            }
            guild.getAudioManager().openAudioConnection(voiceChannel);
        }

        manager.loadTrack(textChannel, command.replaceFirst("!play ",""));

    }
}
