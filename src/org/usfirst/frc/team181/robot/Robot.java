/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Programmed by Laila, Jadyn, Kaleb, and Gwen

package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.SendableBase;
//import edu.wpi.first.wpilibj.SolenoidBase;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Sendable;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	//Defines variables
	private Joystick m_drivestick = new Joystick(0);
	private Joystick m_opstick = new Joystick(1);
	private Timer m_timer = new Timer();

	DriveTrain driveTrain = new DriveTrain(m_drivestick);
		
	@Override
	public void robotInit() {	
		
	}
	
	@Override
	public void autonomousInit() {
		m_timer.reset();
		m_timer.start();
	}
	
	@Override
	public void autonomousPeriodic() {
		// Drive for 2 seconds
		if (m_timer.get() < 2.0) {
			DriveTrain.drive(0.5, 0.0); // drive forwards half speed
		} else {
			DriveTrain.stop(); // stop robot
		}
	}
	
	@Override
	public void teleopInit() {
		//Resets the wheel grippers to no movement
		Gripper.wheelGripReset();
	}	
	
	@Override
	public void teleopPeriodic() {
		//Runs drive program, taking joystick input
		DriveTrain.drive(-m_drivestick.getY(), m_drivestick.getZ());
		//Runs shift gear program
		DriveTrain.ShiftGears();
		//Runs the AutoBrake toggle program
		Elevator.autoToggleDef();
		//Runs the Brake program
		Elevator.brake();
		//Runs the "Elemethod" program	]
		Elevator.elemethod(m_opstick.getY());
		//Runs the Grip program
		Gripper.Grip();
		//Runs the wheel grip program
		Gripper.wheelGrip();
		//Runs the encoder test
		Encoders.testEncoder();
		SmartDashboard.putBoolean("Encoders", (boolean) Encoders.getencoderL());
		
	}
	
	@Override
	public void testPeriodic() {
		
	}	
}