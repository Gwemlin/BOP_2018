package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain {
	
	static DoubleSolenoid VarSolenoid = new DoubleSolenoid(0,0,1);
	
	static VictorSP m_frontLeft = new VictorSP(1);
	static VictorSP m_frontRight = new VictorSP(0);
	
	private static DifferentialDrive m_drive = new DifferentialDrive(m_frontLeft, m_frontRight);
	static Encoder leftEncoder = new Encoder(2, 1, true, Encoder.EncodingType.k4X);
	static Encoder rightEncoder = new Encoder(0, 3, false, Encoder.EncodingType.k4X);
	
	private static Joystick arcadestick;
	
	public DriveTrain(Joystick arcadestick) {
		DriveTrain.arcadestick = arcadestick;
	}
	
	public static void stop() {
		m_drive.stopMotor();
	}
	public static void drive(double forward, double turn) {
		m_drive.arcadeDrive(forward, turn);
	}
	public static void resetEncoders() { 
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

}
