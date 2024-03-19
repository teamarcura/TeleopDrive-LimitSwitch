// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  WPI_TalonSRX rightFront = new WPI_TalonSRX(Constants.DrivetrainConstants.rightFrontCimId);
   WPI_TalonSRX rightBack = new WPI_TalonSRX(Constants.DrivetrainConstants.rightBackCimId);
  WPI_TalonSRX leftFront = new WPI_TalonSRX(Constants.DrivetrainConstants.leftFrontCimId);
  WPI_TalonSRX leftBack = new WPI_TalonSRX(Constants.DrivetrainConstants.leftBackCimId);
 

  public DriveSubsystem() {
    rightBack.configFactoryDefault();
    rightFront.configFactoryDefault();
    leftBack.configFactoryDefault();
    leftFront.configFactoryDefault();

    rightBack.follow(rightFront);
    leftBack.follow(leftFront);
    
  }


  @Override
  public void periodic() {
    SmartDashboard.putNumber("LeftF Speed", leftFront.get());
    SmartDashboard.putNumber("LeftB Speed", leftBack.get());
    SmartDashboard.putNumber("RightB Speed", rightBack.get());
    SmartDashboard.putNumber("RightF Speed", rightFront.get());
  }

  public void setMotors(double LeftSpeed, double RightSpeed) {
    leftFront.set(LeftSpeed);
    leftBack.set(LeftSpeed);
    rightBack.set(RightSpeed);
    rightFront.set(RightSpeed);
  }

  @Override
  public void simulationPeriodic() {
  }
}
