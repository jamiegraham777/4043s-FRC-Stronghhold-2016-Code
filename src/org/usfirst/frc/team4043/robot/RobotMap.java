package org.usfirst.frc.team4043.robot;

import org.usfirst.frc.team4043.robot.AnalogUltrasonic.DistanceUnits;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid;


public class RobotMap {
	
	// Drive
	
    public static SingleEncoder leftEncoder;
    public static SingleEncoder rightEncoder;
    public static Encoder armEncoder1;
    public static SingleEncoder armEncoder2;
    
    public static CANTalon BleftWheel;
    public static CANTalon BrightWheel;
    public static CANTalon FrightWheel;
    public static CANTalon FleftWheel;
    
    public static AnalogUltrasonic sonic;
    public static AnalogGyro gyro;
    
    public static Talon armMotor1;
    public static Talon armMotor2;
    public static Talon suckInMotor;
    public static Talon ballUpMotor;
    
    public static DigitalInput limitLift;
    public static DigitalInput limitLower;
    public static DigitalInput limitBall;
    
	public static int autocounter;
	public static int count, rawCount;
	public static double VPI = 0.00935547;
	public static double kp = 0.03;
	public static double deadband = 0.05;
	public static boolean direction, stopped, armCompleted;
	public static double offset;
    
	public static DoubleSolenoid scaler;
	public static DoubleSolenoid fifthWheel;
    
	//Analog Ports
//	public static final int armIRport = 0;
	

	public static void init() {
		
		//single encoders
		armEncoder2 = new SingleEncoder(Config.armEncoder2, false, Encoder.EncodingType.k1X);
		leftEncoder = new SingleEncoder(Config.leftEncoder, false, Encoder.EncodingType.k1X);
		rightEncoder = new SingleEncoder(Config.rightEncoder, false, Encoder.EncodingType.k1X);
		armEncoder1 = new Encoder(Config.armEncoder1a, Config.armEncoder1b, false, Encoder.EncodingType.k1X);
		
		leftEncoder.setDistancePerPulse(12 * Math.PI * ((1 / 1024f) / 2)); // 12 inches times pi divided by gearbox ratio (2.5 to 5) divided by fps
		rightEncoder.setDistancePerPulse(12 * Math.PI * ((1 / 1024f) / 2));
		armEncoder1.setDistancePerPulse(12 * Math.PI * ((1 / 1024f) / 2));
		armEncoder2.setDistancePerPulse(12 * Math.PI * ((1 / 1024f) / 2));
		
		leftEncoder.setSamplesToAverage(7);
		rightEncoder.setSamplesToAverage(7);
		armEncoder1.setSamplesToAverage(7);
		armEncoder2.setSamplesToAverage(7);
	
		leftEncoder.reset();
		rightEncoder.reset();
		armEncoder1.reset();
		armEncoder2.reset();
		
		//Drive wheels
		
	FrightWheel = new CANTalon(Config.FrightWheel);
	FleftWheel = new CANTalon(Config.FleftWheel);		
	BleftWheel = new CANTalon(Config.BleftWheel);	
	BrightWheel = new CANTalon(Config.BrightWheel);

	//Compressor
	scaler = new DoubleSolenoid(Config.solenoidA, Config.solenoidB);
//	fifthWheel = new DoubleSolenoid(Congfig.solenoidA, Config.solenoidB);
	// Arm motors
	
	armMotor1 = new Talon(Config.armSimMotor);
	armMotor2 = new Talon(Config.armBanMotor);
	
	//Ball pick upper motors
	
	suckInMotor = new Talon(Config.suckinMotor);
	ballUpMotor = new Talon(Config.ballUpMotor);
	
	//Ultrasonic
	
	sonic = new AnalogUltrasonic(2, DistanceUnits.INCHES, VPI);
	sonic.setAverageBits(3);  //(note it is 2^2)
	
	//Limit switches
	
	limitLift = new DigitalInput(Config.limitLift);
	limitLower = new DigitalInput(Config.limitLower);
	limitBall = new DigitalInput(Config.limitBall);
	
	//Gyro
	
	gyro = new AnalogGyro(1);
	gyro.initGyro();
	gyro.calibrate();
	
	//Bossness - basically Peter
	
	}
	
}
