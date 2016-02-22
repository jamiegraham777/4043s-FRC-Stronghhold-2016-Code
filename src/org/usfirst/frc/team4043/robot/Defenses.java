package org.usfirst.frc.team4043.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Defenses{


	public static int tempLeftEncoderCount;
	public static int tempRightEncoderCount;
	
	public Defenses () {
	}
	

	protected void initialize() {
		RobotMap.leftEncoder.reset();
		RobotMap.rightEncoder.reset();
		System.out.println("Left Encoder: " + RobotMap.leftEncoder.getRaw());
		System.out.println("Right Encoder: " + RobotMap.rightEncoder.getRaw());
	}

	public static void execute(int x) {
		int defenseType = x;
		
		if (defenseType == 1) { // drawbridge = arm2 up, arm1 up, arm2 down, arm1 down
			MoveArmTwoForward();
			MoveArmOneForward();
			MoveArmTwoBackward();
			MoveArmOneBackward();
			
		} 
		else if(defenseType == 2) { //portcullis = arm2
			MoveArmOneForward();
			MoveArmTwoForwardWhileArmOneMovesBack();
		}
		else if(defenseType == 3) { //open sallyport door
			tempLeftEncoderCount = RobotMap.leftEncoder.getRaw();
			tempRightEncoderCount = RobotMap.rightEncoder.getRaw();
			MoveArmTwoForward();
			MoveArmOneForward();
			MoveArmOneBackward();
			DriveBackwards();
			
		}
		
	}
	
	private static void MoveArmOneForward() {
		if (RobotMap.armEncoder1.getDistance() < 2) { //TODO test compare get distance versus get Raw
			RobotMap.armMotor1.set(0.25);
			System.out.println("1 One " + RobotMap.armEncoder1.getDistance());
		}
	}
	private static void MoveArmOneBackward() {
		if (RobotMap.armEncoder1.getDistance() < 3) {
			RobotMap.armMotor1.set(-0.25);
			System.out.println("1 Two " + RobotMap.armEncoder1.getDistance());
		}
	}
	private static void MoveArmTwoForward() {
		if (RobotMap.armEncoder2.getDistance() < 4) {
			RobotMap.armMotor2.set(0.25);
			System.out.println("2 One " + RobotMap.armEncoder2.getDistance());
		}
	}
	private static void MoveArmTwoBackward() {
		if (RobotMap.armEncoder2.getDistance() < 5) {
			RobotMap.armMotor2.set(-0.5);
			System.out.println("2 Two " + RobotMap.armEncoder2.getDistance());
		}
	}
	private static void MoveArmTwoForwardWhileArmOneMovesBack() {
		if (RobotMap.armEncoder1.getRaw() < 6) {
			RobotMap.armMotor2.set(0.3);
			RobotMap.armMotor1.set(-0.5);
			
			RobotMap.FleftWheel.set(0.3);
			RobotMap.FrightWheel.set(-0.3);
			RobotMap.BleftWheel.set(0.3);
			RobotMap.BrightWheel.set(-0.3);
			
			System.out.println("Three " + RobotMap.armEncoder1.getRaw());
		}
	}
	private static void DriveBackwards() {
		if (RobotMap.rightEncoder.getRaw() != (RobotMap.leftEncoder.getRaw() + 2)) {
			RobotMap.armMotor2.set(-0.25);
			RobotMap.armMotor1.set(-0.25);
			System.out.println("Drive: " + RobotMap.rightEncoder.getRaw());
			}
		}
	

	protected boolean isFinished() {
		
		RobotMap.leftEncoder.reset();
		RobotMap.rightEncoder.reset();
		System.out.println("Left Encoder: " + RobotMap.leftEncoder.getRaw());
		System.out.println("Right Encoder: " + RobotMap.rightEncoder.getRaw());
		
		return false;
	}

	protected void end() {
		
		RobotMap.leftEncoder.reset();
		RobotMap.rightEncoder.reset();
		System.out.println("Left Encoder: " + RobotMap.leftEncoder.getRaw());
		System.out.println("Right Encoder: " + RobotMap.rightEncoder.getRaw());
		
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
