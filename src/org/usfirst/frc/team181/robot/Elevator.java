package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;

public class Elevator {
	
	static Spark m_elevator = new Spark(2);
	static Spark m_elsparkDown = new Spark(6);
	static Spark m_elsparkUP = new Spark(7);
	
	public static Joystick elevatorstick;
	
	public Elevator(Joystick elevatorstick) {
		Elevator.elevatorstick = elevatorstick;
	}

	public static void elemethod(double y) {
		m_elevator.set(y);
	}
}