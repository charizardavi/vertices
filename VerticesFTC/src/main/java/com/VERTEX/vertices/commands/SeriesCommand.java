package com.VERTEX.vertices.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeriesCommand extends Command{
    private List<Command> commands = new ArrayList<>();
    private int commandIndex = 0;
    private boolean finished = false;

    public SeriesCommand(Command... inputCommands){
        commands.addAll(Arrays.asList(inputCommands));
    }


    @Override
    public void init(){
        commandIndex = 0;
        if (!commands.isEmpty()) {
            commands.get(0).init();
        }
    }

    @Override
    public void loop(){
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

    @Override
    public boolean isFinished(){
        return finished;
    }
}
