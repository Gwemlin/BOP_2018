/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Programmed by Laila, Jadyn, Kaleb, and Gwen

package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team181.robot.AutoCross;
import org.usfirst.frc.team181.robot.AutoSwitch;

public class Robot extends IterativeRobot {
	//Defines variables
	private Joystick m_drivestick = new Joystick(0);
	private Joystick m_opstick = new Joystick(1);
	private Timer m_timer = new Timer();
	
	static SendableChooser<Object> autoChooser;
	Command autonomousCommand;
	
	DriveTrain driveTrain = new DriveTrain(m_drivestick);
		
	@Override
	public void robotInit() {	
		autoChooser = new SendableChooser<Object>();
		autoChooser.addDefault("Cross Line", new AutoCross());
		autoChooser.addObject("Switch Deposit", new AutoSwitch());
		SmartDashboard.putData("Autonomous Chooser", autoChooser);
	}
	
	@Override
	public void autonomousInit() {
		m_timer.reset();
		m_timer.start();
		autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		/*
		// Drive for 2 seconds
		if (m_timer.get() < 2.0) {
			DriveTrain.drive(0.5, 0.0); // drive forwards half speed
		} else {
			DriveTrain.stop(); // stop robot
		}
		*/
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
		//SmartDashboard.putBoolean("Encoders", (boolean) Encoders.getencoderL());
		
	}
	
	@Override
	public void testPeriodic() {
		Autonomous.autoSwitch();
	}	
}