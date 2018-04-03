//Created by Gwen Miller & Laila Yost :3 2018

package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.Timer; 
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class AutoScale extends Command {
	char fromSide;
	
	static char fromLeft = 2;
	static char fromRight = 3;
	
	public static Timer autoTimer = new Timer();
	private Timer elevTimer = new Timer();
	
	public static AnalogInput ultraSonic = new AnalogInput(0);
		
	char ScaleSide = 0;
	
	boolean brakeStat = true;
	boolean eleUp = false;
	boolean inPos1 = false;
	boolean inPos2 = false;
	boolean inPos3 = false;
	
	AutoScale(char fromSide) {
		this.fromSide = fromSide;
	}
	
	public void initialize() {
		autoTimer.reset();
		autoTimer.start();
		elevTimer.reset();
		elevTimer.start();
		String gameData;
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		if(gameData.length() > 0){
			ScaleSide = gameData.charAt(0);
		}
		if((ScaleSide == 'L' && fromSide == fromLeft) || (ScaleSide == 'R' && fromSide == fromRight)){
			Elevator.brakeOff();
			brakeStat = false;
		} 
		else {
			brakeStat = true;
		}
		
	}
		
	public void execute() {
		double rawDist = ultraSonic.getVoltage();
		Boolean ultraStop = (rawDist > 0.24);
		if(fromSide == fromLeft) {
			if (elevTimer.get() < 1 && brakeStat == false) {
				Elevator.elemethod(0.55); 
				brakeStat = false;
				eleUp = false;
			}			
			else {
				Elevator.elemethod(0.0); 
				Elevator.brakeOn();
				brakeStat = true;
				eleUp = true;
			}
				if (ultraStop == false && eleUp == true) {
					DriveTrain.drive(0.65, 0);
					inPos1 = false;
				}
				else {
					DriveTrain.stop();
					inPos1 = true;
				}
					if (eleUp == true && inPos1 == true /*add gyro turn here*/) {
						DriveTrain.drive(0, -45);
						inPos2 = false;
					}
					else {
						DriveTrain.stop();
						inPos2 = true;
					}
						if (ScaleSide == 'L' && inPos2 == true && eleUp == true) {
				
						}else if (ScaleSide == 'R' && inPos2 == true && eleUp == true) {
				
						}
		}
				
		if(fromSide == fromRight){
			if (elevTimer.get() < 1 && brakeStat == false) {
				Elevator.elemethod(0.55); 
				brakeStat = false;
				eleUp = false;
			}			
			else {
				Elevator.elemethod(0.0); 
				Elevator.brakeOn();
				brakeStat = true;
				eleUp = true;
			}
				if (ultraStop == false && eleUp == true) {
					DriveTrain.drive(0.65, 0);
						inPos1 = false;
				}
				else {
					DriveTrain.stop();
					inPos1 = true;
				}
					if (eleUp == true && inPos1 == true /*add gyro turn here*/) {
						DriveTrain.drive(0, 45);
						inPos2 = false;
					}
					else {
						DriveTrain.stop();
						inPos2 = true;
					}
						if (ScaleSide == 'R' && inPos2 == true && eleUp == true) {
							DriveTrain.drive(0, 45);
						}else if (ScaleSide == 'L' && inPos2 == true && eleUp == true) {
							
						}
		}
				
	}
	
	public void end() {
		DriveTrain.drive(0, 0);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
