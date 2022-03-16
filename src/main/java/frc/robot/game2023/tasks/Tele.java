package frc.robot.game2023.tasks;

import frc.robot.lib.components.DriveTrain;
import frc.robot.game2023.modules.Climber;
import frc.robot.game2023.modules.Combine;

import frc.robot.lib.tools.Camera;

public class Tele {
    private final DriveTrain driveTrain;
    private final Camera camera;
    private final Climber climber;
    private final Combine combine;
    public Tele(DriveTrain driveTrain, Camera camera, Climber climber, Combine combine){
        this.driveTrain = driveTrain;
        this.camera = camera;
        this.climber = climber;
        this.combine = combine;
    }
    public void init(){
        this.camera.setDriverMode(true);
    }
    public void loop(){
        // teleop periodic code here
    }
}
