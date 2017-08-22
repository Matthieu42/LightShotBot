package fr.matthieu42.gollumbot.command;

import fr.matthieu42.gollumbot.music.MusicManager;
import fr.matthieu42.gollumbot.music.MusicPlayer;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ClearCommand extends MusicCommand {

    public ClearCommand(MusicManager manager) {
        super("!clear", "Vide la liste de lecture",manager);
    }

    @Override
    public void execute(MessageReceivedEvent event) {
        TextChannel textChannel = event.getTextChannel();
        MusicPlayer player = manager.getPlayer(textChannel.getGuild());

        if(player.getListener().getTracks().isEmpty()){
            textChannel.sendMessage("Encore aucune piste à suivre ... J'attends vos ordres Maître !").queue();
            return;
        }

        player.getListener().getTracks().clear();
        textChannel.sendMessage("Toutes les pistes ont été supprimées, elles ont disparues... comme mon précieux !").queue();
    }
}
