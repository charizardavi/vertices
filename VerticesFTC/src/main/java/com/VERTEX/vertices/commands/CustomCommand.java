package com.VERTEX.vertices.commands;

public class CustomCommand extends Command{
    private Runnable toRun;
    public CustomCommand(Runnable toRunInput){
        toRun = toRunInput;
    }

    @Override
    public void init(){
        toRun.run();
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}
