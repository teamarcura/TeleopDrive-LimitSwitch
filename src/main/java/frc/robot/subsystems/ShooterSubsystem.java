package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import java.util.TimerTask;

public class ShooterSubsystem extends SubsystemBase {

    private CANSparkMax Shooter1 = new CANSparkMax(Constants.ShooterConstants.shooter1Id, MotorType.kBrushless);
    private CANSparkMax Shooter2 = new CANSparkMax(Constants.ShooterConstants.shooter2Id, MotorType.kBrushed);
    private CANSparkMax Shooter3 = new CANSparkMax(Constants.ShooterConstants.shooter3Id, MotorType.kBrushless);
    private CANSparkMax Shooter4 = new CANSparkMax(Constants.ShooterConstants.shooter4Id, MotorType.kBrushless);
    boolean isRunning;

    public ShooterSubsystem() {
        Shooter1.setInverted(false);
        Shooter2.setInverted(true);
        Shooter3.setInverted(false);
        Shooter4.setInverted(true);
    }

    public void setShooter(double speed) {
        Shooter4.set(speed);
        Shooter3.set(speed);
    }
    public void setFeeder(double speed) {
        Shooter1.set(speed);
        Shooter2.set(speed);
    }
    
    
    public void ShootBabe(final double shooterTime, final double feederTime, final double speed) {
        
        TimerTask stopTask = new TimerTask() {
            @Override
            public void run() {
                setShooter(0);
                setFeeder(0);
                isRunning = false;
            }
        };

        TimerTask shooterTask = new TimerTask() {
            @Override
            public void run() {
                setShooter(1);
                isRunning = true;
            }
        };

        TimerTask feederTask = new TimerTask() {
            @Override
            public void run() {
                setFeeder(1);
                isRunning = true;
            }
        };

        java.util.Timer timer = new java.util.Timer();
        
        timer.schedule(shooterTask, 0);
        isRunning = true;
        timer.schedule(feederTask, (long) shooterTime * 1000);
        isRunning = true;
        timer.schedule(stopTask, (long) (shooterTime + feederTime) * 1000);
        
        
    }
    public boolean isShooterRunning() {
        return isRunning;
    }
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Shooter1 Speed", Shooter1.get());
        SmartDashboard.putNumber("Shooter2 Speed", Shooter2.get());
        SmartDashboard.putNumber("Shooter3 Speed", Shooter3.get());
        SmartDashboard.putNumber("Shooter4 Speed", Shooter4.get());
    }
        
}
