package org.usfirst.frc.team4043.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive2 {

    public static CANTalon BleftWheel;
    public static CANTalon BrightWheel;
    public static CANTalon FrightWheel;
    public static CANTalon FleftWheel;
    
    boolean bSpeedControl = SmartDashboard.getBoolean("Speed Control", true);
    
    WCDLeftPIDOutput wcdLeftPIDOutput;
    WCDRightPIDOutput wcdRightPIDOutput;
    
    public double requestedPowerLeft, requestedPowerRight;
    
    public PIDController leftController, rightController;
    
    class WCDLeftPIDSource implements PIDSource {
    	public double pidGet() {
    		return RobotMap.leftEncoder.getRate(); //TODO LOOK AT CLASS AND CONFIRM
  
    	}

		@Override
		public void setPIDSourceType(PIDSourceType pidSource) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public PIDSourceType getPIDSourceType() {
			// TODO Auto-generated method stub
			return null;
		}
    }
    
class WCDRightPIDSource implements PIDSource {
	public double pidGet() {
		return RobotMap.rightEncoder.getRate(); //TODO
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return null;
	}
}

class WCDLeftPIDOutput implements PIDOutput {
	public double prevScale = 1.0;
	public void pidWrite (double output) {
		output *= Math.signum(requestedPowerLeft);
		prevScale += output;
		if (prevScale >= 10.0) {
			prevScale = 10.0;
		}
		else if(prevScale <= 0.01) {
			prevScale = 0.01;
		}
		setLeftPower( prevScale * requestedPowerLeft);
	}
}
class WCDRightPIDOutput implements PIDOutput {
	public double prevScale = 1.0;
	public void pidWrite (double output) {
		output *= Math.signum(requestedPowerRight);
		prevScale += output;
		if (prevScale >= 10.0) {
			prevScale = 10.0;
		}
		else if(prevScale <= 0.01) {
			prevScale = 0.01;
		}
		setLeftPower( prevScale * requestedPowerRight);
	}
}
//protected void initDefaultCommand() {
//	setDefaultCommand(new Drive());
//}

	public Drive2() {
		
		double kp = 0.01;
		double kI = 0.0;
		double kD = 0.03;
		
		BleftWheel = RobotMap.BleftWheel;
	    BrightWheel = RobotMap.BrightWheel;
	    FrightWheel = RobotMap.FrightWheel;
	    FleftWheel = RobotMap.FleftWheel;
	    
	    wcdLeftPIDOutput = new WCDLeftPIDOutput();
	    wcdRightPIDOutput = new WCDRightPIDOutput();
	    
	    leftController = new PIDController (kp, kI, kD, new WCDLeftPIDSource(), wcdLeftPIDOutput );
	    rightController = new PIDController (kp, kI, kD, new WCDRightPIDSource(), wcdRightPIDOutput);
	    
	    SmartDashboard.putData("PID Left: ", leftController);
	    SmartDashboard.putData("PID Right: ", rightController);
	    SmartDashboard.putBoolean("Speed Control: ", bSpeedControl);
	    
	}
	
	public void driveConfig( double x, double y) {
	    SmartDashboard.putNumber("Left Encoder: ", RobotMap.leftEncoder.getRate());
	    SmartDashboard.putNumber("Right Encoder: ", RobotMap.rightEncoder.getRate());
	    
	    double deadband = RobotMap.deadband;
	    if (x <= deadband && x >= -deadband) {
	    	x = 0;
	    }
	    if(y <= deadband && y >= - deadband) {
	    	y = 0;
	    }
	}
	
	public void setRightPower(double x) {
		BrightWheel.set(x);
		FrightWheel.set(x);
	}
	
	public void setLeftPower(double x) {
		BleftWheel.set(x);
		FleftWheel.set(x);
	}
	
	public void SetSpeed(double right, double forward) {
		bSpeedControl = SmartDashboard.getBoolean("Speed Control", true);
		
		if (bSpeedControl) 
		{
			leftController.enable();
			rightController.enable();
		}
		else {
			leftController.disable();
			rightController.disable();
		}
		
		if(bSpeedControl) {
			double a = forward + right;
			double b = forward - right;
			double maxPower = Math.max(Math.abs(a), Math.abs(b));
			if (maxPower > 1.0) {
				a /= maxPower;
				b /= maxPower;
			}
			
			if (a==0) {
				wcdLeftPIDOutput.prevScale = 1.0;
			}
			if (b==0) {
				wcdRightPIDOutput.prevScale = 1.0;
			}
			
			requestedPowerLeft = a;
			requestedPowerRight = b;
			
			leftController.setSetpoint(20.0 * a);
			rightController.setSetpoint(20.0 * b);
			
		}
		else
		{
			setLeftPower(forward + right);
			setLeftPower(forward - right);
		}
	}
}
