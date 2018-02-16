//Created by Gwen 2018
package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;

public class Elevator {
	//Defines variables
	static Spark m_elevator = new Spark(2);
	
	static DoubleSolenoid BrakeSol = new DoubleSolenoid(0,4,5);

	public static Joystick opstick;
	
	public Elevator(Joystick elevatorstick) {
		Elevator.opstick = elevatorstick;
	}
	
	public static void elemethod(double y) {	//Defines the "Elemethod" program
		m_elevator.set(y);	//sets the input for "elemethod" to the "y" for the Spark motor-controller
	}
	
	public static void brakeOn() {
		BrakeSol.set(DoubleSolenoid.Value.kForward);
	}
	
	public static void brakeOff() {
		BrakeSol.set(DoubleSolenoid.Value.kReverse);
	}
	
	public static void Brake() {
		if(opstick.getRawButton(1) == true) {
			brakeOn();
			System.out.println("Brake Engaged!");
		}
		if(opstick.getRawButton(4) == true) {
			brakeOff();
			System.out.println("Brake Disengaged!");
		}
		
	}

}


