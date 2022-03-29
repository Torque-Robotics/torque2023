package frc.robot.game2023.modules;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Climber {
    private final WPI_TalonSRX arm;
    private final WPI_TalonSRX hand;
    public Climber(int arm, int hand){
        this.arm = new WPI_TalonSRX(arm);
        this.hand = new WPI_TalonSRX(hand);
        this.arm.setNeutralMode(NeutralMode.Brake);
        this.arm.setNeutralMode(NeutralMode.Brake);
    }
    public void moveArm(ControlMode mode, double power){
        this.arm.set(mode, power);
    }
    public void movehand(ControlMode mode, double power){
        this.hand.set(mode, power);
    }
}
