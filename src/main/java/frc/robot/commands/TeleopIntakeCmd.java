package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class TeleopIntakeCmd extends Command {

  private final IntakeSubsystem IntakeSubsystem;

  public TeleopIntakeCmd(IntakeSubsystem IntakeSubsystem) {
    this.IntakeSubsystem = IntakeSubsystem;
    addRequirements(IntakeSubsystem);
  }


  @Override
  public void initialize() {
    SmartDashboard.putString("IntakeCommand", "IntakeCommand has started.");
  }

  @Override
  public void execute() {
    double speed = 0.5;
    if (RobotContainer.joystick.getRawButtonPressed(Constants.ControllerConstants.teleopIntakebtn)) {
        IntakeSubsystem.setMotors(speed);
    }
    if(RobotContainer.joystick.getRawButton(Constants.ControllerConstants.teleopStopbtn)){
      IntakeSubsystem.setMotors(0);
    }
  }
  

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
