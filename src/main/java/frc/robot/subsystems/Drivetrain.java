// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  private final CANSparkMax leftFront = new CANSparkMax(6, MotorType.kBrushed);//4 for other bot
  private final CANSparkMax leftBack = new CANSparkMax(3, MotorType.kBrushed);//3 for wide bot
  private final CANSparkMax rightFront = new CANSparkMax(7, MotorType.kBrushed);//2 for wide bot
  private final CANSparkMax rightBack = new CANSparkMax(4, MotorType.kBrushed);//1 for wide bot

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftFront.restoreFactoryDefaults();
    leftBack.restoreFactoryDefaults();
    rightFront.restoreFactoryDefaults();
    rightBack.restoreFactoryDefaults();

    rightBack.follow(rightFront);
    leftBack.follow(leftFront);
  }

  public void drive(double speed, double turn){
    double left = (speed + turn) * 0.5;
    double right = (speed - turn) * 0.5;

    leftFront.set(left);
    rightFront.set(-right);
  }

  public void stop(){
    drive(0, 0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
