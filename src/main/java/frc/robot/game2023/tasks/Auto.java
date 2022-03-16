package frc.robot.game2023.tasks;

import frc.robot.lib.components.DriveTrain;
import frc.robot.game2023.modules.Combine;

import frc.robot.lib.tools.Camera;

public class Auto {
    private final DriveTrain driveTrain;
    private final Camera camera;
    private final Combine combine;
    public Auto(DriveTrain driveTrain, Camera camera, Combine combine){
        this.driveTrain = driveTrain;
        this.camera = camera;
        this.combine = combine;
    }
    public void init(){
        this.camera.setDriverMode(false);
    }
    public void loop(){
        // autonomous periodic code here
    }
}
