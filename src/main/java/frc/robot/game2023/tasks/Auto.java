package frc.robot.game2023.tasks;

import frc.robot.lib.components.DriveTrain;
import frc.robot.lib.components.Camera;

public class Auto {
    private final DriveTrain driveTrain;
    private final Camera camera;
    public Auto(DriveTrain driveTrain, Camera camera){
        this.driveTrain = driveTrain;
        this.camera = camera;
    }
    public void init(){
        this.camera.setDriverMode(false);
    }
    public void loop(){
        // autonomous periodic code here
    }
}
