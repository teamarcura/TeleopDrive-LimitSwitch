package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class TeleopDriveCommand extends Command {

  private final DriveSubsystem driveSubsystem;

  public TeleopDriveCommand(DriveSubsystem driveSubsystem) {
    this.driveSubsystem = driveSubsystem;
    addRequirements(driveSubsystem);
    
  }


  @Override
  public void initialize() {
    SmartDashboard.putString("DriveCommand", "DriveCommand has started.");
  }

  @Override
  public void execute() {
    double forwardSpeed = RobotContainer.joystick.getRawAxis(Constants.ControllerConstants.teleopForward);
    double turnSpeed = RobotContainer.joystick.getRawAxis(Constants.ControllerConstants.teleopTurn);

    double leftMotorSpeed = forwardSpeed - turnSpeed;
    double rightMotorSpeed = forwardSpeed + turnSpeed;

    driveSubsystem.setMotors(-leftMotorSpeed*0.5, rightMotorSpeed*0.5);

  }
  

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.setMotors(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
