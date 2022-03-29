package frc.robot.game2023.tasks;

import frc.robot.lib.components.DriveTrain;
import frc.robot.game2023.modules.Combine;

import frc.robot.lib.tools.Camera;

public class Auto {
    // robot modules
    private final DriveTrain driveTrain;
    private final Camera camera;
    private final Combine combine;

    // task variables
    private int phase;
    private int count;
    public Auto(DriveTrain driveTrain, Camera camera, Combine combine){
        this.driveTrain = driveTrain;
        this.camera = camera;
        this.combine = combine;
    }
    public void init(){
        this.camera.setDriverMode(false);
        this.phase = 1;
        this.count = 0;
    }
    public void loop(){
        switch(phase){ // code for each phase

        }
        count();
    }
    public void count(){
        this.count++;
    }
    public boolean hasPassed(int count){
        return (this.count >= count);
    }
    public void done(){
        this.phase++;
    }
}
