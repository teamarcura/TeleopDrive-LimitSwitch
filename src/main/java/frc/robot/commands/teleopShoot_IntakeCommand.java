package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class teleopShoot_IntakeCommand extends Command{
    private final ShooterSubsystem shooterSubsystem;
    private final IntakeSubsystem intakeSubsystem;

    public teleopShoot_IntakeCommand(ShooterSubsystem shooterSubsystem, IntakeSubsystem intakeSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(shooterSubsystem, intakeSubsystem);
    }

    public void initialize() {
        SmartDashboard.putString("IntakeCommand", "IntakeCommand has started.");
    }

    public void execute() {
        double shooterSpeed = 0.5;
        double intakeSpeed = 0.5;

        if (RobotContainer.joystick.getRawButtonPressed(Constants.ControllerConstants.teleopShooterbtn)) {
            shooterSubsystem.setShooter(shooterSpeed);
            shooterSubsystem.setFeeder(shooterSpeed);
        }
        if (RobotContainer.joystick.getRawButtonPressed(Constants.ControllerConstants.teleopIntakebtn)) {
            intakeSubsystem.setMotors(intakeSpeed);
        }

        if (RobotContainer.joystick.getRawButton(Constants.ControllerConstants.teleopStopbtn)) {
            shooterSubsystem.setFeeder(0);
            shooterSubsystem.setShooter(0);
            intakeSubsystem.setMotors(0);
        }
    }

    public void end(boolean interrupted) {
        // End logic if needed
    }
}
