package frc.robot.game2023.modules;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.lib.Config;

public class Combine {
    private final WPI_TalonSRX arm;
    private final WPI_TalonSRX hand;
    public Combine(int arm, int hand){
        this.arm = new WPI_TalonSRX(arm);
        this.hand = new WPI_TalonSRX(hand);
        this.arm.setNeutralMode(NeutralMode.Brake);
        this.hand.setNeutralMode(NeutralMode.Brake);
    }
    public void moveArm(ControlMode mode, double power){
        this.arm.set(mode, power);
    }
    public void moveIntake(ControlMode mode, double power){
        this.hand.set(mode, power);
    }
}
