package fr.matthieu42.gollumbot.command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public abstract class Command {
    private final String name;
    private final String description;

    protected Command(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public abstract void execute(MessageReceivedEvent event);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
