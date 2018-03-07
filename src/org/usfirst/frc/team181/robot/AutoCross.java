//Created by Gwen Miller 2018

package org.usfirst.frc.team181.robot;

public class AutoCross {
	public static void autoCross() {
		DriveTrain.drive(2, 0);
		DriveTrain.drive(0, 90);
		DriveTrain.drive(2,0);
		DriveTrain.drive(0,-90);
		DriveTrain.drive(2,0);
	}
}
