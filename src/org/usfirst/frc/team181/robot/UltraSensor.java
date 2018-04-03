package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class UltraSensor {

	static AnalogInput ultraRange = new AnalogInput(0);
	static double distance = (0);

	public static void calcDistance() {
		double volts = ultraRange.getVoltage();
		distance = volts;
		System.out.println(volts);
	}
	
}