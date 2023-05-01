package com.VERTEX.vertices.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandRunner{
    private List<Command> commands = new ArrayList<>();
    private int commandIndex = 0;
    private boolean finished = false;

    public CommandRunner (Command... inputCommands){
        commands.addAll(Arrays.asList(inputCommands));
    }

    public void start(){
        commandIndex = 0;
        if (!commands.isEmpty()) {
            commands.get(0).init();
        }
    }

    public void update(){
        commands.get(commandIndex).loop();
        if (commands.get(commandIndex).isFinished()){
            if (commandIndex == commands.size() - 1){
                finished = true;
            }
            else{
                commandIndex = commandIndex + 1;
            }
        }
    }

    public void addCommand(Command inputAddCommand){
        commands.add(inputAddCommand);
    }


    public boolean isFinished(){
        return finished;
    }
}
