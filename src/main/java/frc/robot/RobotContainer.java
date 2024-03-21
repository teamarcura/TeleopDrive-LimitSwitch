// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.TeleopDriveCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;



public class RobotContainer {

  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

  private final TeleopDriveCommand teleopDriveCommand = new TeleopDriveCommand(driveSubsystem, shooterSubsystem, intakeSubsystem);
  public static Joystick joystick = new Joystick(0);

  
  public RobotContainer() {
    configureBindings();
    driveSubsystem.setDefaultCommand(teleopDriveCommand);
    shooterSubsystem.setDefaultCommand(teleopDriveCommand);
    intakeSubsystem.setDefaultCommand(teleopDriveCommand);
  }


  private void configureBindings() {

  }


  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;  
  }
}
