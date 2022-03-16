package frc.robot.game2023.tasks;

import frc.robot.lib.components.DriveTrain;
import frc.robot.lib.tools.Camera;

public class Tele {
    private final DriveTrain driveTrain;
    private final Camera camera;
    public Tele(DriveTrain driveTrain, Camera camera){
        this.driveTrain = driveTrain;
        this.camera = camera;
    }
    public void init(){
        this.camera.setDriverMode(true);
    }
    public void loop(){
        // teleop periodic code here
    }
}
