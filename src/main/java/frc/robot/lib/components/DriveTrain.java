package frc.robot.lib.components;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;//Mainly for debugging
import frc.robot.lib.ConfigurationService;



/**
 * Created by Nick Sloss on 1/31/17.
 */
public class DriveTrain
{
    //40, 20 and 12 <- gears, according to Alenna

    public final WPI_TalonSRX LeftMaster;
    public final WPI_TalonSRX LeftSlave;
    public final WPI_TalonSRX RightMaster;
    public final WPI_TalonSRX RightSlave;

    /**
     * Constructor for DriveTrain.
     */
    public DriveTrain() 
    {
        LeftMaster = new WPI_TalonSRX(ConfigurationService.DRIVETRAIN_LEFT_LEADER);
        RightMaster = new WPI_TalonSRX(ConfigurationService.DRIVETRAIN_RIGHT_LEADER);
        LeftSlave = new WPI_TalonSRX(ConfigurationService.DRIVETRAIN_LEFT_FOLLOWER);
        RightSlave = new WPI_TalonSRX(ConfigurationService.DRIVETRAIN_RIGHT_FOLLOWER);

        this.configTalons();
    }

    /**
     * Configures talons of the DriveTrain with 2 motors on each side in a Master-Follower config.
     */
    public void configTalons() 
    {
        /** 
         * Notes: -Use [motor.configContinuousCurrentLimit(value)] if we're ever worried about the 
         *        drivetrain somehow pulling too much power and making the robot die
         *        -And remember to [motor.enableCurrentLimit(true] if you do the above
         *        -Also, this class was written for a drivetrain using 2 motors on each side to drive
         *        (hence the Follower and Master setup)
         */
        LeftSlave.set(ControlMode.Follower, LeftMaster.getDeviceID());
        RightSlave.set(ControlMode.Follower, RightMaster.getDeviceID());

        LeftMaster.setNeutralMode(NeutralMode.Coast);
        RightMaster.setNeutralMode(NeutralMode.Coast);

        LeftSlave.setNeutralMode(NeutralMode.Coast);
        RightSlave.setNeutralMode(NeutralMode.Coast);
    }

    /** 
     * Set each side of the robot to drive a certain percentage
     * @param left Percentage of power from 0.01 to 1 left motor
     * @param right Percentage of power from 0.01 to 1 to right motor
     * unused with PID, only use voltage output
     */
    public void drivePercentageOutput(double left, double right) 
    {
        LeftMaster.set(ControlMode.PercentOutput, left);
        RightMaster.set(ControlMode.PercentOutput, right);
    }

    /**
     * Set each side of the robot to drive with a certain amount of voltage (no PID or error correction)
     * @param left Volts, from 0 to 10 left motor
     * @param right Volts, from 0 to 10 right motor
     */
    public void driveVoltageOutput(double left, double right)
    {
        LeftMaster.setVoltage(left);
        RightMaster.setVoltage(right);
    }
}
