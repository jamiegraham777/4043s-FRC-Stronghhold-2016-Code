
package org.usfirst.frc.team4043.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables2.type.NumberArray;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

//******************[ Start Code ]*********************************************************************


/* TODO:
 * 1. Download frc suite update
 * 2. Reimage the roborio
 * 2.5b. Test solenoids with code
 * 2.5a. Write the solenoid code
 * 3. Test vision tracking code
 * 3a. Adjust arrays and stuff 
 * 3b. Play with numbers until it works
 * 3c. Don't be afraid to add more smart dashboard review code for vision variables
 * 4. PID Controllers.... Test what we have thus far in Drive2 (note that Drive doesn't work because its code for mecanum that I used over summer)
 * 4a. Test constant values P, I, and D in smart dashboard and find one that works best
 * 4b. Play with numbers until it works
 * 5. Rearrange smart dashboard in visibly efficient manner and test with camera, vision tracking, and PID
 * 6. Test autonomous that we have right now
 * 7. Write 5 autonmous for different starting places on the field
 * 7a. Add a autonomous placement chooser into smart dashboard
 * 7b. In code, getNumber from dashboard to choose which autonomous to run
 * 8. ReCAD our 3D model (after build season) and run in simulator
 */


public class Robot extends SampleRobot {
	// CameraServer server;
	public static OI oi;
	public static Joystick xbox, xbox2; // xbox; // set to ID 1 in DriverStation
	public static Vision vision;
	public static SmartDashboard smartDashboard;
    
	int autocounter;
	int count, rawCount;
	int defForward, manualAllowed;
	double distance, period, rate, VPI = 0.00935547;
	boolean direction, stopped, armCompleted;
	double offset;
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    SendableChooser chooser;
//	LaserCounter laserCounter;
//  AnalogUltrasonic sonic;
	AnalogGyro gyro;
	

	public Robot() {
		oi = new OI();
		RobotMap.init();
		vision = Vision.getInstance();
		defForward = 1;
		manualAllowed = 1;

		armCompleted = true;

	}
	
	
	 public void robotInit() {
	        chooser = new SendableChooser();
	        chooser.addDefault("Default Auto", defaultAuto);
	        chooser.addObject("My Auto", customAuto);
	        SmartDashboard.putData("Auto modes", chooser);
	    }
	

	public void operatorControl() {
	//	sonic.resetAccumulator();

		// System.out.println("ArmIR " + armIR.getVoltage());

	//	 double angle = gyro.getAngle();
		 
		while (isOperatorControl() && isEnabled()) {
			
			
//			System.out.println("Distance:  " + sonic.getDistance());
//			System.out.println("Volt: " + sonic.getVoltage());
		//	System.out.println("AvgDistance " + sonic.getAverageDistance());
       //	System.out.println("Gyro: " +  gyro.getAngle() * 0.03);
			//System.out.println("Encoder2: " + RobotMap.armEncoder2.getDistance() * 0.03);
			//System.out.println("offset: " + offset);
	
           //System.out.println("armEncoder Raw : " + RobotMap.armEncoder1.getRaw());
//			 System.out.println("left Raw: " + RobotMap.leftEncoder.getRaw());
//			 System.out.println("armEncoder Raw: " + RobotMap.armEncoder2.getRaw());
//			 System.out.println("right Raw" + RobotMap.rightEncoder.getRaw());
			
			 SmartDashboard.putNumber("armEncoder1 Raw : ", RobotMap.armEncoder1.getRaw());
			 SmartDashboard.putNumber("left Raw: ", RobotMap.leftEncoder.getRaw());
			 SmartDashboard.putNumber("armEncoder2 Raw: ", RobotMap.armEncoder2.getRaw());
			 SmartDashboard.putNumber("right Raw", RobotMap.rightEncoder.getRaw());
//			 
			 SmartDashboard.putNumber("armEncoder1 Raw : ", RobotMap.armEncoder1.getDistance());
			 SmartDashboard.putNumber("left Raw: ", RobotMap.leftEncoder.getDistance());
			 SmartDashboard.putNumber("armEncoder2 Raw: ", RobotMap.armEncoder2.getDistance());
			 SmartDashboard.putNumber("right Raw", RobotMap.rightEncoder.getDistance());
			 
//			 SmartDashboard.putData("Distance:  " + sonic.getDistance());
//			 SmartDashboard.putData("Volt: " + sonic.getVoltage());
//			 SmartDashboard.putNumber("Ultrasonic: ", sonic.getAverageDistance());

         	 SmartDashboard.putNumber("Gyro: ", (gyro.getAngle() * RobotMap.kp));
	//		 smartDashboard.putDouble("Encoder2: ", (RobotMap.armEncoder2.getDistance() * 0.03));
//				System.out.println("offset: " + offset);
//		
//				System.out.println("armEncoder Raw : " + RobotMap.armEncoder1.getRaw());
//				 System.out.println("left Raw: " + RobotMap.leftEncoder.getRaw());
//				 System.out.println("armEncoder Raw: " + RobotMap.armEncoder2.getRaw());
//				 System.out.println("right Raw" + RobotMap.rightEncoder.getRaw());
//				 
// ************************[ Ball Picker-upper]***********************************************************************
			//TODO

//			if (OI.boulderPickerUpperDown.get() == true) {
//				PickerUpperMotion(2);
//			}
//			if (OI.boulderPickerUpperUp.get() == true) {
//				PickerUpperMotion(1);
//			}
//			if (OI.drawBridge.get() == true) {
//				if (RobotMap.armEncoder1.getDistance() < 20)
//				Defenses.execute(1);
//			}
//			if (OI.portcullis.get() == true) {
//				if (RobotMap.armEncoder1.getDistance() < 20)
//				Defenses.execute(2);
//			}
//			if (OI.openDoor.get() == true) {
//				if (RobotMap.armEncoder1.getDistance() < 20)
//				Defenses.execute(3);
//			}
//			OI.boulderPickerUpperUp.whenPressed(new BallPickerUpper());
//			OI.boulderPickerUpperDown.whenPressed(new BallPickerUpper(0));
//			OI.drawBridge.whenPressed(new Defenses());
//			OI.portcullis.whenPressed(new Defenses(0));
//			OI.openDoor.whenPressed(new Defenses(0,0));
			
			
			
//************************[ Switch robot drive direction ]********************************************************
			if (OI.switchDirection.get() == true) { //switchDirection = new JoystickButton(coStick, 5); //trigger Right
				defForward *= -1;
			}
//*********************[ Switch robot arm to manual button ] *****************************************************
//			if (OI.switchToManual.get() == true) {
//				manualAllowed *= -1;
//			}
			
			// ****************[ drives robot]*********************************************************************

			if (OI.driverStick.getRawAxis(5) > 0.15 || OI.driverStick.getRawAxis(5) < -0.15)  {
				//		driveStraight(xbox.getRawAxis(5));
				//		FrightWheel.set(-xbox.getRawAxis(5)); // * (1-(offset
				//		BrightWheel.set(-xbox.getRawAxis(5));
				RobotMap.FrightWheel.set((-OI.driverStick.getRawAxis(5) * 0.75) * defForward);
				RobotMap.BrightWheel.set((-OI.driverStick.getRawAxis(5) * 0.75) * defForward);
					}

			 else if (OI.driverStick.getRawAxis(5) < 0.15 || OI.driverStick.getRawAxis(5) > -0.15) {
				// leftEncoder.reset();
				// NormalEncoder.reset();
				RobotMap.FrightWheel.set(0);
				RobotMap.BrightWheel.set(0);
			} 
			
			if (OI.driverStick.getRawAxis(1) > 0.15 || OI.driverStick.getRawAxis(1) < -0.15) {
//				System.out.println("left: " + leftEncoder.getRaw());
//				System.out.println("Normal: " + rightEncoder.getRaw());
				RobotMap.FleftWheel.set((OI.driverStick.getRawAxis(1) * 0.75) * defForward);
				RobotMap.BleftWheel.set((OI.driverStick.getRawAxis(1) * 0.75) * defForward);
			} else if (OI.driverStick.getRawAxis(1) < 0.15 || OI.driverStick.getRawAxis(1) > -0.15) {
				// leftEncoder.reset();
				// NormalEncoder.reset();
				RobotMap.FleftWheel.set(0);
				RobotMap.BleftWheel.set(0);
			} 
			
			//*****************[ Suck Ball in or out]***************************************************
			if (!RobotMap.limitBall.equals(1)) {
			if (OI.coStick.getRawAxis(1) > 0.15 || OI.coStick.getRawAxis(1) < -0.15) {
				RobotMap.suckInMotor.set(-(OI.coStick.getRawAxis(1) * 0.75));
			}
			else if (OI.coStick.getRawAxis(1) < 0.15 || OI.coStick.getRawAxis(1) > -0.15) {
				RobotMap.suckInMotor.set(0);
			}
			}
			
			//****************[ New ball picker upper up and down]****************************************************
			
			
			if (OI.coStick.getRawAxis(5) > 0.15 || OI.coStick.getRawAxis(5) < -0.15)  {
				//		driveStraight(xbox.getRawAxis(5));
				//		FrightWheel.set(-xbox.getRawAxis(5)); // * (1-(offset
				//		BrightWheel.set(-xbox.getRawAxis(5));
				RobotMap.ballUpMotor.set(-OI.coStick.getRawAxis(5) * 0.5);
					}

			 else if (OI.coStick.getRawAxis(5) < 0.15 || OI.coStick.getRawAxis(5) > -0.15) {
				// leftEncoder.reset();
				// NormalEncoder.reset();
				RobotMap.ballUpMotor.set(0);
			}  
			


			//*****************[ Switch robot arm to manual ] *******************************************
			
		/*	if (manualAllowed == -1) {
				if ((RobotMap.armEncoder1.getRaw() > 70  && RobotMap.armEncoder1.getRaw() < 80) && (RobotMap.armEncoder2.getRaw() > 80 && RobotMap.armEncoder2.getRaw() < 90))
				{
					if (RobotMap.armEncoder1.getRaw()  > 40 || RobotMap.armEncoder2.getRaw()  > 50) {
						RobotMap.armMotor1.set(-0.5);
						RobotMap.armMotor2.set(-0.5);
					}
					else if (RobotMap.armEncoder1.getRaw()  > 40 || RobotMap.armEncoder2.getRaw()  > 50)  {
						RobotMap.armMotor1.set(0);
						RobotMap.armMotor2.set(0);
					}
				
				if (OI.coStick.getRawAxis(1) > 0.15 || OI.coStick.getRawAxis(1) < -0.15) {
					RobotMap.armMotor1.set(-0.5);
				}
				else if (OI.coStick.getRawAxis(1) < 0.15 || OI.coStick.getRawAxis(1) > -0.15) {
					RobotMap.armMotor1.set(-0.5);
				}
				if (OI.coStick.getRawAxis(5) > 0.15 || OI.coStick.getRawAxis(5) < -0.15) {
					RobotMap.armMotor2.set(-0.5);
				}
				else if (OI.coStick.getRawAxis(5) < 0.15 || OI.coStick.getRawAxis(5) > -0.15) {
					RobotMap.armMotor2.set(0);
				}
	//TODO test compare get Raw versus get Distance
				} */
				
			}
		
		Timer.delay(0.005); //Needs to be 0.005 for competition
	
	}
	
	/*private void PickerUpperMotion (int x)
	{
		int upOrDown = x;
		System.out.println("Command Running " + RobotMap.limitLift);
		if (upOrDown == 2) { // go UP
			System.out.println("Lift limit switch: " + RobotMap.limitLift);
			if (!(RobotMap.limitLift.equals(1))) {
				RobotMap.ballUpMotor.set(0.25);
			} else if (RobotMap.limitLift.equals(1)) {
				RobotMap.ballUpMotor.set(0);
			}
		} else if (upOrDown == 1) { // go DOWN
			System.out.println("Lower limit switch: " + RobotMap.limitLower);
			if (!(RobotMap.limitLower.equals(1))) {
				RobotMap.ballUpMotor.set(-0.25);
			} else if (RobotMap.limitLower.equals(1)) {
				RobotMap.ballUpMotor.set(0);
		} */
		

/*	public static void execute(int x) {
		int defenseType = x;
		
		if (defenseType == 1) { // drawbridge = arm2 up, arm1 up, arm2 down, arm1 down
			MoveArmTwoForward();
			MoveArmOneForward();
			MoveArmTwoBackward();
			MoveArmOneBackward();
			
		} 
		else if(defenseType == 2) { //portcullis = arm2
			MoveArmOneForward();
		//	MoveArmTwoForwardWhileArmOneMovesBack();
		}
		else if(defenseType == 3) { //open sallyport door
			MoveArmTwoForward();
			MoveArmOneForward();
			MoveArmOneBackward();
			DriveBackwards();
			
		} */
		
	
/*	private static void MoveArmOneForward() {
		if (RobotMap.armEncoder1.getDistance() < 10) { //TODO test compare get distance versus get Raw
			RobotMap.armMotor1.set(-0.25);
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

		//Y 
		
*/
	

	public void autonomous() {
		
		if (isEnabled()) {
		String autoSelected1 = (String) chooser.getSelected();
	//	String autoSelected2 = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected1);
    	
    	switch(autoSelected1) {
    	case customAuto:

			RobotMap.FrightWheel.set(0.5);
			RobotMap.FleftWheel.set(0.5);
			RobotMap.FleftWheel.set(-0.5);
			RobotMap.BleftWheel.set(-0.5);
			Timer.delay(3); //depends on battery count
			RobotMap.FrightWheel.set(0);
			RobotMap.FleftWheel.set(0);
			RobotMap.FleftWheel.set(0);
			RobotMap.BleftWheel.set(0);
			Timer.delay(12); //just in case it loops
            break;
    	case defaultAuto:

			RobotMap.FrightWheel.set(0.5);
			RobotMap.FleftWheel.set(0.5);
			RobotMap.FleftWheel.set(-0.5);
			RobotMap.BleftWheel.set(-0.5);
			Timer.delay(3); //depends on battery count
			RobotMap.FrightWheel.set(0);
			RobotMap.FleftWheel.set(0);
			RobotMap.FleftWheel.set(0);
			RobotMap.BleftWheel.set(0);
			Timer.delay(12); //just in case it loops
			break;
    	default:

			RobotMap.FrightWheel.set(0.5);
			RobotMap.FleftWheel.set(0.5);
			RobotMap.FleftWheel.set(-0.5);
			RobotMap.BleftWheel.set(-0.5);
			Timer.delay(3); //depends on battery count
			RobotMap.FrightWheel.set(0);
			RobotMap.FleftWheel.set(0);
			RobotMap.FleftWheel.set(0);
			RobotMap.BleftWheel.set(0);
			Timer.delay(12); //just in case it loops
            break;

				}
	}
}
}