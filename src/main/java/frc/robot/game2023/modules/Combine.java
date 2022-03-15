package frc.robot.game2023.modules;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Combine {
    private final WPI_TalonSRX arm;
    private final WPI_TalonSRX intake;
    public Combine(WPI_TalonSRX arm, WPI_TalonSRX intake){
        this.arm = arm;
        this.intake = intake;
        this.arm.setNeutralMode(NeutralMode.Brake);
        this.intake.setNeutralMode(NeutralMode.Brake);
    }
    public void moveArm(ControlMode mode, double power){
        this.arm.set(mode, power);
    }
    public void moveIntake(ControlMode mode, double power){
        this.intake.set(mode, power);
    }
}
