package org.usfirst.frc.team4043.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Config {

	
	public static Joystick driverStick, coStick;
	public static JoystickButton portcullis;
	public static JoystickButton openDoor;
	public static JoystickButton drawBridge;
	public static JoystickButton switchToManual;
	
	public static JoystickButton boulderPickerUpperUp;
	public static JoystickButton boulderPickerUpperDown;
	public static JoystickButton suckIn;
	public static JoystickButton suckOut;
	public static JoystickButton turnRight90;
	public static JoystickButton turnLeft90;
	
	//Analog Ports
//	public static int armIRport = 0;
	
	//PWM Ports
	public static int armSimMotor = 1;
	public static int armBanMotor = 2;
	public static int suckinMotor = 3;
	public static int ballUpMotor = 4;
	public static int limitLift = 5;
	public static int limitLower = 6;
	public static int limitBall = 7;
	
	//DIO Ports
	public static int rightEncoder = 0;
	public static int leftEncoder = 1;
	public static int armEncoder1a = 2;
	public static int armEncoder1b = 3;
	public static int armEncoder2 = 4;
			
	//CAN Talons
	public static int FleftWheel = 9; //x
	public static int FrightWheel = 1;
	public static int BleftWheel = 10; //x
	public static int BrightWheel = 2; //check
	
	//Solenoid channels
	public static int solenoidA = 0;
	public static int solenoidB = 1;

	
	
}
