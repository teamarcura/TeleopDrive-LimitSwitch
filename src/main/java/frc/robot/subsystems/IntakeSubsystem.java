package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase{
    private CANSparkMax intake1 = new CANSparkMax(Constants.IntakeConstants.intake1Id,  MotorType.kBrushed);
    private CANSparkMax intake2 = new CANSparkMax(Constants.IntakeConstants.intake2Id, MotorType.kBrushed);
    public IntakeSubsystem() {
        intake1.setInverted(false);
        intake2.setInverted(false);
        
    }
    public void setMotors(double speed) {
        intake1.set(speed);
        intake2.set(speed);
    }
    
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Intake1 Current", intake1.get());
        SmartDashboard.putNumber("Intake2 Current", intake2.get());
    }
    
}
