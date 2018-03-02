package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class UltraSensor {

	static AnalogInput ultraRange = new AnalogInput(0);
	static double distance = (0);

	public static void calcDistance() {
		double volts = ultraRange.getVoltage();
		distance = volts/12;
	}
	
	public static void ultraLeft() {
		calcDistance();
		System.out.println(distance);
		DriveTrain.drive(1,0);
	}
	
	public static void ultraRight() {
		calcDistance();
		System.out.println(distance);
		DriveTrain.drive(1,0);
	}
}