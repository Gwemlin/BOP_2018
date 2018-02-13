package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;


public class ElevatorBreak {
	static DoubleSolenoid BrakeSol = new DoubleSolenoid(4,5);
	static Joystick opstick = new Joystick(1);
	
	static VictorSP Brake = new VictorSP(4);
	
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
		//if(opstick.getRawButton(2) == true && drivestick.getRawButton(2) == false) {	//if the "2" button pressed on the operator stick, run the program
			//startGrip();	//runs the "startGip" program
			//System.out.println("Gripping");
		//}
}

}