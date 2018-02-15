//Created by Gwen 2018
package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;

public class Elevator {
	//Defines variables
	static Spark m_elevator = new Spark(2);

	public static Joystick opstick;
	
	public Elevator(Joystick elevatorstick) {
		Elevator.opstick = elevatorstick;
	}
	
	public static void elemethod(double y) {	//Defines the "Elemethod" program
		m_elevator.set(y);	//sets the input for "elemethod" to the "y" for the Spark motor-controller
	}
	

}


