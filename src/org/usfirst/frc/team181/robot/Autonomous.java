// created by Evan Belcourt , Gwen, and Laila in 2018
package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.Timer;
/*import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
*/
import edu.wpi.first.wpilibj.DriverStation;

public class Autonomous {
	
	public static void setAlliance() {
		
	}
	
	public void crossLine() {
		final Timer m_autotimer = new Timer();
		
		DriveTrain.drive(0.5,1);
		
		// Drive for 2 seconds
		if (m_autotimer.get() < 2.0) {
			DriveTrain.drive(0.5, 0.0); // drive forwards half speed
		} 
		else {
			DriveTrain.stop(); // stop robot
		}
	}
	
	String gameData; {
	gameData = DriverStation.getInstance().getGameSpecificMessage();
            if(gameData.length() > 0)
            {
	  if(gameData.charAt(0) == 'L');
		//Left auto code here
	  } else if(gameData.charAt(0) == 'R'){
		//Put right auto code here
	  } 
}
}
