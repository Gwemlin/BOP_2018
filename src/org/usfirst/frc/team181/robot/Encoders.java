// made By Evan and Matt in 2018
package org.usfirst.frc.team181.robot;

import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Encoders {
	
	private double distancePerPulse = 0.05;
	
	static Encoder encoderR = new Encoder(0,1,false, Encoder.EncodingType.k4X);
	static Encoder encoderL = new Encoder(2,3, false, Encoder.EncodingType.k4X);
	static Encoder encoderElevator = new Encoder(4,5, false,Encoder.EncodingType.k4X);
	
		public Encoders(){
			encoderR.setDistancePerPulse(distancePerPulse);
			encoderL.setDistancePerPulse(distancePerPulse);
			encoderElevator.setDistancePerPulse(distancePerPulse);		
		}
		
		//return right encoder value with distance
		public static double readEncoderR() {
			return encoderR.getDistance();
		}
		//return left encoder distance value
		public static double readEncoderL() {
			return encoderL.getDistance();
		}
		public static double readEncoderElevator() {
			return encoderElevator.getDistance();
		}
		//set all encoder values to 0
		public static void resetEncoders() {
			encoderL.reset();
			encoderR.reset();
			encoderElevator.reset();			
		}
}
	
