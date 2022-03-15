package frc.robot.game2023.modules;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Climb {
    private final WPI_TalonSRX arm;
    private final WPI_TalonSRX hand;
    public Climb(WPI_TalonSRX arm, WPI_TalonSRX hand){
        this.arm = arm;
        this.hand = hand;
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
