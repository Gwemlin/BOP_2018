//Created by Gwen Miller 2018

package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class AutoSwitch {
	public static void autoSwitch() {
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
