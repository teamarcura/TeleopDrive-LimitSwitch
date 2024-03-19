package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

public class TeleopShooterCmd extends Command {
    private final ShooterSubsystem shooterSubsystem;

    public TeleopShooterCmd(ShooterSubsystem shooterSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        addRequirements(shooterSubsystem);
    }

    @Override
    public void initialize() {
        SmartDashboard.putString("ShooterCommand", "ShooterCommand has started.");
    }

    @Override
    public void execute() {
        double speed = 0.5;
        if (RobotContainer.joystick.getRawButtonPressed(Constants.ControllerConstants.teleopShooterbtn)) {
            shooterSubsystem.setShooter(speed);
            shooterSubsystem.setFeeder(speed);
        }
        if(RobotContainer.joystick.getRawButton(Constants.ControllerConstants.teleopStopbtn)){
            shooterSubsystem.setFeeder(0);
            shooterSubsystem.setShooter(0);
        }

        
        
    }

    @Override
    public void end(boolean interrupted) {
        
    }
    
    
}
