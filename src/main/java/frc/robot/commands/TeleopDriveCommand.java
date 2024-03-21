package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class TeleopDriveCommand extends Command {

  private final DriveSubsystem driveSubsystem;
  private final ShooterSubsystem shooterSubsystem;
  private final IntakeSubsystem intakeSubsystem;
  Timer timer = new Timer();
  public TeleopDriveCommand(DriveSubsystem driveSubsystem, ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem) {
    this.driveSubsystem = driveSubsystem;
    this.shooterSubsystem = shooterSubsystem;
    this.intakeSubsystem = intakeSubsystem;
    addRequirements(driveSubsystem, shooterSubsystem, intakeSubsystem);
  }

  @Override
  public void initialize() {
    SmartDashboard.putString("DriveCommand", "DriveCommand has started.");
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
    double forwardSpeed = RobotContainer.joystick.getRawAxis(Constants.ControllerConstants.teleopForward);
    double turnSpeed = RobotContainer.joystick.getRawAxis(Constants.ControllerConstants.teleopTurn);

    double leftMotorSpeed = forwardSpeed - turnSpeed;
    double rightMotorSpeed = forwardSpeed + turnSpeed;

    driveSubsystem.setMotors(-leftMotorSpeed*0.5, rightMotorSpeed*0.5);

    double shooterSpeed = 1;
    double intakeSpeed = 0.5;

    SmartDashboard.putNumber("timer", timer.get());

    JoystickButton intakeButton = new JoystickButton(RobotContainer.joystick, Constants.ControllerConstants.teleopIntakebtn);
    intakeButton.toggleOnTrue(new InstantCommand(() -> 
    {
      intakeSubsystem.setMotors(intakeSpeed);
    }));

    JoystickButton outİntakeButton = new JoystickButton(RobotContainer.joystick, Constants.ControllerConstants.teleopIntakeOutbtn);
    outİntakeButton.toggleOnTrue(new InstantCommand(() -> 
    {
      intakeSubsystem.setMotors(-intakeSpeed);
    }));

    JoystickButton shooterIntakeButton = new JoystickButton(RobotContainer.joystick, Constants.ControllerConstants.teleopShooterIntakebtn);
    shooterIntakeButton.toggleOnTrue(new InstantCommand(() -> 
    {
      shooterSubsystem.setShooter(-0.4);
      shooterSubsystem.setFeeder(-0.1);
    }));


    SmartDashboard.putString("isRunning", String.valueOf(shooterSubsystem.isShooterRunning()));

    JoystickButton shootButton = new JoystickButton(RobotContainer.joystick, Constants.ControllerConstants.teleopShooterbtn);
    if (shooterSubsystem.isShooterRunning() !=true)
    {

      shootButton.toggleOnTrue(new InstantCommand(() -> 
      {
      shooterSubsystem.ShootBabe(2, 2, shooterSpeed);
      }));

    }

    JoystickButton stopButton = new JoystickButton(RobotContainer.joystick, Constants.ControllerConstants.teleopStopbtn);
    stopButton.toggleOnTrue(new InstantCommand(() -> 
    {
      shooterSubsystem.setShooter(0);
      shooterSubsystem.setFeeder(0);
      intakeSubsystem.setMotors(0);
    }));
         
  }
          
  @Override
  public void end(boolean interrupted) {
  driveSubsystem.setMotors(0, 0);
  shooterSubsystem.setShooter(0);
  shooterSubsystem.setFeeder(0);
  intakeSubsystem.setMotors(0);
  SmartDashboard.putString("DriveCommand", "DriveCommand has ended.");
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
