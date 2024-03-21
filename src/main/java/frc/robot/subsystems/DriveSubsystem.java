// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  WPI_TalonSRX rightFront = new WPI_TalonSRX(Constants.DrivetrainConstants.rightFrontCimId);
  WPI_TalonSRX rightBack = new WPI_TalonSRX(Constants.DrivetrainConstants.rightBackCimId);
  WPI_TalonSRX leftFront = new WPI_TalonSRX(Constants.DrivetrainConstants.leftFrontCimId);
  WPI_TalonSRX leftBack = new WPI_TalonSRX(Constants.DrivetrainConstants.leftBackCimId);
  DutyCycleEncoder rightEncoder = new DutyCycleEncoder(Constants.DrivetrainConstants.rightEncoderPort);
  DutyCycleEncoder leftEncoder = new DutyCycleEncoder(Constants.DrivetrainConstants.leftEncoderPort);

  public DriveSubsystem() {
    rightBack.configFactoryDefault();
    rightFront.configFactoryDefault();
    leftBack.configFactoryDefault();
    leftFront.configFactoryDefault();

  }


  @Override
  public void periodic() {
    SmartDashboard.putNumber("LeftF Speed", leftFront.get());
    SmartDashboard.putNumber("LeftB Speed", leftBack.get());
    SmartDashboard.putNumber("RightB Speed", rightBack.get());
    SmartDashboard.putNumber("RightF Speed", rightFront.get());
    SmartDashboard.putNumber("Left Encoder", leftEncoder.getDistance());
    SmartDashboard.putNumber("Right Encoder", rightEncoder.getDistance());
  }

  public void setMotors(double LeftSpeed, double RightSpeed) {
    
    double deadband = 0.05;
    if (Math.abs(LeftSpeed) < deadband) {
      LeftSpeed = 0;
    }

    if (Math.abs(RightSpeed) < deadband) {
      RightSpeed = 0;
    }
    leftFront.set(LeftSpeed);
    rightFront.set(RightSpeed);
    leftBack.set(LeftSpeed);
    rightBack.set(RightSpeed);
    
  }

  @Override
  public void simulationPeriodic() {
  }
}
