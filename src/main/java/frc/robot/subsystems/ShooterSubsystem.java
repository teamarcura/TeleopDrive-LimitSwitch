package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

    private CANSparkMax Shooter1 = new CANSparkMax(Constants.ShooterConstants.shooter1Id, MotorType.kBrushless);
    private CANSparkMax Shooter2 = new CANSparkMax(Constants.ShooterConstants.shooter2Id, MotorType.kBrushed);
    private CANSparkMax Shooter3 = new CANSparkMax(Constants.ShooterConstants.shooter3Id, MotorType.kBrushless);
    private CANSparkMax Shooter4 = new CANSparkMax(Constants.ShooterConstants.shooter4Id, MotorType.kBrushless);


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

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Shooter1 Speed", Shooter1.get());
        SmartDashboard.putNumber("Shooter2 Speed", Shooter2.get());
        SmartDashboard.putNumber("Shooter3 Speed", Shooter3.get());
        SmartDashboard.putNumber("Shooter4 Speed", Shooter4.get());
    }
        
}
