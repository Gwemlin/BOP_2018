package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;

public class Gripper {
	
	static DoubleSolenoid GripperSol = new DoubleSolenoid(0,2,3);
	static Joystick drivestick = new Joystick(0);
	static Joystick opstick = new Joystick(1);
	
	public static void startGrip() {
		GripperSol.set(DoubleSolenoid.Value.kForward);
	}	
	public static void unGrip() {
		GripperSol.set(DoubleSolenoid.Value.kReverse);
	}
	public static void Grip() {
		if(drivestick.getRawButton(2) == true) {
			startGrip();
			System.out.println("Gripping");
		}
		if(drivestick.getRawButton(2) == false) {
			unGrip();
			System.out.println("Letting Go");
		}
		if(opstick.getRawButton(2) == true) {
			startGrip();
			System.out.println("Gripping");
		}
		if(opstick.getRawButton(2) == false) {
			unGrip();
			System.out.println("Letting Go");
		}
	}
}