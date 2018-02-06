/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.SendableBase;
//import edu.wpi.first.wpilibj.SolenoidBase;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends IterativeRobot {
	
	private Joystick m_arcadestick = new Joystick(0);
	private Timer m_timer = new Timer();

	DriveTrain driveTrain = new DriveTrain(m_arcadestick);
		
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
	}

	
		
	@Override
	public void teleopPeriodic() {
		DriveTrain.drive(m_arcadestick.getY(), -m_arcadestick.getZ());
		DriveTrain.ShiftGears();
	}

	@Override
	public void testPeriodic() {
	}
}