//Created by Gwen Miller & Laila Yost 2018

package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team181.robot.Elevator;
import org.usfirst.frc.team181.robot.Gripper;

public class AutoSwitch extends Command {
	char autoDirection;
	char fromSide;
	private Timer m_timer = new Timer();
	private Timer elevTimer = new Timer();
	
	static char Switch = 0;
	static char Straight = 1;
	
	static char fromLeft = 2;
	static char fromRight = 3;
	static char fromMiddle = 4;
	
	char SwitchSide = 0;
	
	boolean brakeStat = true;
	boolean eleUp = false;
	boolean inPos = false;
	
	AutoSwitch(char autoDirection, char fromSide) {
		this.autoDirection = autoDirection;
		this.fromSide = fromSide;
	}
	
	public void initialize() {
		m_timer.reset();
		m_timer.start();
		elevTimer.reset();
		elevTimer.start();
		eleUp = false;
		inPos = false;
		String gameData;
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		if(gameData.length() > 0){
			SwitchSide = gameData.charAt(0);
		}
		
		if((SwitchSide == 'L' && autoDirection == Switch && fromSide == fromLeft) || 
				(SwitchSide == 'R' && autoDirection == Switch && fromSide == fromRight)){
			Elevator.brakeOff();
			brakeStat = false;
		} 
		else {
			brakeStat = true;
		}
		
	}
	
	public void execute() {
		if((SwitchSide == 'L' && autoDirection == Switch && fromSide == fromLeft) || 
			(SwitchSide == 'R' && autoDirection == Switch && fromSide == fromRight)){
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
			if (m_timer.get() < 5.5 && eleUp == true) {
				DriveTrain.drive(0.65, 0.0);
				inPos = false;
			}
			else {
				DriveTrain.stop();
				inPos = true;
			}
			if (inPos == true && eleUp == true) {
				Gripper.wheelGripIn(); 
			}
			
		} 
		else if((autoDirection == Straight) || 
			(SwitchSide == 'R' && fromSide == fromLeft) || 
			(SwitchSide == 'L' && fromSide == fromRight)){
			if (m_timer.get() < 4.5) {
				DriveTrain.drive(0.65, 0.0); } else {
				DriveTrain.stop();
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
