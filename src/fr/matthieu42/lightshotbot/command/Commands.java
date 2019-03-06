package fr.matthieu42.lightshotbot.command;

import java.util.Collection;
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
        String strNew = name.replace("!", "");
        return commands.get(strNew);
    }
    public Collection<Command> getCommandList(){
        return commands.values();
    }
}
