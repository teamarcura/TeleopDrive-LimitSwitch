// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.TeleopDriveCommand;
import frc.robot.commands.teleopShoot_IntakeCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;



public class RobotContainer {

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

  private final TeleopDriveCommand teleopDriveCommand = new TeleopDriveCommand(driveSubsystem);
  private final teleopShoot_IntakeCommand teleopShoot_IntakeCommand = new teleopShoot_IntakeCommand(shooterSubsystem, intakeSubsystem);
  public static Joystick joystick = new Joystick(0);

  
  public RobotContainer() {
    configureBindings();
    driveSubsystem.setDefaultCommand(teleopDriveCommand);
    intakeSubsystem.setDefaultCommand(teleopShoot_IntakeCommand);
    shooterSubsystem.setDefaultCommand(teleopShoot_IntakeCommand);
  }


  private void configureBindings() {
    
  }


  public Command getAutonomousCommand() {
    return null;
  }
}
