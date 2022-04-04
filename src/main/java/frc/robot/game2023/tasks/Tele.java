package frc.robot.game2023.tasks;

import frc.robot.lib.components.DriveTrain;
import frc.robot.game2023.modules.Climber;
import frc.robot.game2023.modules.Combine;
import frc.robot.lib.tools.Camera;
import frc.robot.lib.components.Xbox;
import frc.robot.lib.Config;

public class Tele {
    private final DriveTrain driveTrain;
    private final Camera camera;
    private final Climber climber;
    private final Combine combine;
    private final Xbox xbox;
    public Tele(DriveTrain driveTrain, Camera camera, Climber climber, Combine combine, Xbox xbox){
        this.driveTrain = driveTrain;
        this.camera = camera;
        this.climber = climber;
        this.combine = combine;
        this.xbox = xbox;
    }
    public void init(){
        this.camera.setDriverMode(true);
    }
    public void loop(){
        // teleop periodic code here
    }
}
