// created by Evan Belcourt , Gwen, and Laila in 2018
package org.usfirst.frc.team181.robot;

/*import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
*/
import edu.wpi.first.wpilibj.DriverStation;

public class Autonomous {
	
	public static void setAlliance() {
		
	}
	
	public static void autoCode() {
		String gameData; {
			gameData = DriverStation.getInstance().getGameSpecificMessage();
			if(gameData.length() > 0){
				if(gameData.charAt(0) == 'L'); 
					UltraSensor.ultraLeft();
		  		} else if(gameData.charAt(0) == 'R'){
		  			UltraSensor.ultraRight();
			  } 
			
		}
		
	}
	
}

