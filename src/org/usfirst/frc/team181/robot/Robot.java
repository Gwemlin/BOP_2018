/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.SendableBase;
//import edu.wpi.first.wpilibj.SolenoidBase;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.VictorSP;

public class Robot extends IterativeRobot {
	
	private Joystick m_arcadestick = new Joystick(0);
	public static Joystick arcadestick = new Joystick(0);
	private Timer m_timer = new Timer();
	static DoubleSolenoid VarSolenoid = new DoubleSolenoid(0,0,1);
	
	static VictorSP m_frontLeft = new VictorSP(1);
	static VictorSP m_frontRight = new VictorSP(0);
	
	private DifferentialDrive m_drive = new DifferentialDrive(m_frontLeft, m_frontRight);
	static Encoder leftEncoder = new Encoder(2, 1, true, Encoder.EncodingType.k4X);
	static Encoder rightEncoder = new Encoder(0, 3, false, Encoder.EncodingType.k4X);
		
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
			m_drive.arcadeDrive(0.5, 0.0); // drive forwards half speed
		} else {
			m_drive.stopMotor(); // stop robot
		}
	}

	@Override
	public void teleopInit() {
	}

	private static void resetEncoders() { 
		// TODO Auto-generated method stub
	}

	public static void highGear() {
		resetEncoders();
		VarSolenoid.set(DoubleSolenoid.Value.kForward);
		//doubleSolenoid.set(true);
		resetEncoders();
	}
	
	public static void lowGear() {
		resetEncoders();
		VarSolenoid.set(DoubleSolenoid.Value.kReverse);
		//doubleSolenoid.set();
		resetEncoders();
	}
		
	public static void ShiftGears() {
		//If button 1 is pressed, and high gear is not yet enabled, run high gear method in DriveTrain class. Change State variable.
		if(arcadestick.getRawButton(1) == true){
			System.out.println("Engaging High Gear!");
			highGear();
			VarSolenoid.set(DoubleSolenoid.Value.kForward);			
		}
		else{
			System.out.println("Going to Low Gear!");
			lowGear();
			VarSolenoid.set(DoubleSolenoid.Value.kReverse);}
	}
		
	@Override
	public void teleopPeriodic() {
		m_drive.arcadeDrive(m_arcadestick.getY(), -m_arcadestick.getZ());
		ShiftGears();
	}

	@Override
	public void testPeriodic() {
	}
}