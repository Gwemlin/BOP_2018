package org.usfirst.frc.team181.robot;
//Created by Laila 2018
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;

public class ElevatorBreak {
	static DoubleSolenoid BrakeSol = new DoubleSolenoid(4,5);
	static Joystick opstick = new Joystick(1);
	
	public static void brakeOn() {
		BrakeSol.set(DoubleSolenoid.Value.kForward);
	}
	
	public static void brakeOff() {
		BrakeSol.set(DoubleSolenoid.Value.kOff);
	}
	
	public static void Brake() {
		if(opstick.getRawButton(1) == true && opstick.getRawButton(4) == false) {
			brakeOn();
			System.out.println("Brake Engaged!");
		}
		if(opstick.getRawButton(1) == false && opstick.getRawButton(4) == true) {
			brakeOff();
			System.out.println("Brake Disengaged!");
		}
	}

}