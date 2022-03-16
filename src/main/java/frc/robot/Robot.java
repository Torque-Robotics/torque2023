/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.lib.Config;

import frc.robot.lib.components.DriveTrain;
import frc.robot.game2023.modules.Climber;
import frc.robot.game2023.modules.Combine;

import frc.robot.lib.tools.Camera;

import frc.robot.game2023.tasks.Auto;
import frc.robot.game2023.tasks.Tele;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private DriveTrain driveTrain;
  private Climber climber;
  private Combine combine;

  private Camera camera;

  private final double cameraPosition[] = {0,0,0};
  private final double cameraAngle[] = {0,0,0};

  private Auto auto;
  private Tele tele;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    this.driveTrain = new DriveTrain();
    this.climber = new Climber(Config.CLIMB_ARM, Config.CLIMB_HAND);
    this.combine = new Combine(Config.COMBINE_ARM, Config.COMBINE_HAND);

    this.camera = new Camera(this.cameraPosition,this.cameraAngle);

    this.auto = new Auto(driveTrain, camera, combine);
    this.tele = new Tele(driveTrain, camera, climber, combine);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() 
  {
    
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    this.auto.init();
  }
  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    this.auto.loop();
  }
  @Override
	public void teleopInit() 
	{
    this.tele.init();
	}
  /**
   * This function is called periodically during operator control.
   */

  @Override
  public void teleopPeriodic() {
    this.auto.loop();
  }
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic()
  {

  }
  @Override
	public void disabledInit()
	{
   
	}
	@Override
	public void disabledPeriodic()
	{

	}
}