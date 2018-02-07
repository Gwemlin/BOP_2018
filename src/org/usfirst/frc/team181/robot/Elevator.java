package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;

public class Elevator {
	
	static Spark m_elevator = new Spark(2);
	
	public static Joystick opstick;
	
	public Elevator(Joystick elevatorstick) {
		Elevator.opstick = elevatorstick;
	}
	
	public static void elemethod(double y) {
		m_elevator.set(y);
	}
}