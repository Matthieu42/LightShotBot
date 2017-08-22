package fr.matthieu42.gollumbot.command;

import java.util.HashMap;
import java.util.Map;

public class Commands {
    private final Map<String,Command> commands;

    public Commands() {
        this.commands = new HashMap<>();
    }

    public void addCommand(Command command){
        commands.put(command.getName(),command);
    }
    public void addCommands(Command ... commands){
        for(Command command : commands){
            this.commands.put(command.getName(),command);
        }
    }
    public void delCommand(String name){
        commands.remove(name);
    }
    public Command getCommand(String name){
        return commands.get(name);
    }
}
