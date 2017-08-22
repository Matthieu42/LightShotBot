package fr.matthieu42.gollumbot.command;

import fr.matthieu42.gollumbot.music.MusicManager;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class SoundboardCommand extends MusicCommand{

    protected SoundboardCommand(String name, String description, MusicManager manager) {
        super(name, description, manager);
    }

    @Override
    public void execute(MessageReceivedEvent event) {

    }
}
