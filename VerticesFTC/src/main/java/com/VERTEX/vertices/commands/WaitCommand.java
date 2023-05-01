package com.VERTEX.vertices.commands;

public class WaitCommand extends Command{
    double targetTime;
    double startTime;

    public WaitCommand(double inputTime){
        targetTime = inputTime;
    }

    @Override
    public void init(){
        startTime = System.currentTimeMillis();
    }

    @Override
    public boolean isFinished(){
        return System.currentTimeMillis()-startTime > targetTime;
    }
}
