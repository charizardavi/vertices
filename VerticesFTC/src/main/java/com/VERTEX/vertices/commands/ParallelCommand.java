package com.VERTEX.vertices.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParallelCommand extends Command{
    private List<Command> commands = new ArrayList<>();
    private boolean finished = false;
    private boolean tempFinished;
    public ParallelCommand(Command... inputCommands){
        commands.addAll(Arrays.asList(inputCommands));
    }


    @Override
    public void init(){
        if (!commands.isEmpty()) {
            for (Command command : commands){
                command.init();
            }
        }
    }

    @Override
    public void loop(){
        tempFinished = true;
        for (Command command : commands){
            command.loop();
            if (!command.isFinished()){
                tempFinished = false;
            }
        }
        finished = tempFinished;
    }

    @Override
    public boolean isFinished(){
        return finished;
    }
}
