package fr.matthieu42.gollumbot.command;

import fr.matthieu42.gollumbot.music.MusicManager;

public abstract class MusicCommand extends Command{

    protected final MusicManager manager;
    protected MusicCommand(String name, String description,MusicManager manager) {
        super(name, description);
        this.manager = manager;
    }


}
