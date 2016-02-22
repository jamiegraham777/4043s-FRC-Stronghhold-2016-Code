package org.usfirst.frc.team4043.robot;

import edu.wpi.first.wpilibj.Timer;

public class PID {
	
	private double kP;
	private double kI;
	private double kD;
	private double errorSum;
	private double error;
	private double previousError;
	private double previousTime;
	private double output;
	private double errorMax = 0;
	private double errorMin = 0;
	private Timer timer;
	
	public PID(double p, double i, double d) {
		kP = p;
		kI = i;
		kD = d;
		previousTime = 0;
		output = 0;
	}
	
	public void update(double current, double want) {
		double dError;
		double dt = timer.get() - previousTime;   // Delta T
		previousTime = timer.get();
		error = current - want;
		errorSum += error * dt;
		
		if (errorSum > errorMax) {
			errorSum = errorMax;
		}
		else if (errorSum < errorMin) {
			errorSum = errorMin;
		}
	
		dError = (error - previousError) / dt;
		output = (error * kP) + (errorSum * kI) + (dError * kD);
		previousError = error;
		
	}
	
	public void reset() {
		output = 0;
		errorSum = 0;
		previousError = 0;
		previousTime = 0;
	}

	public double getOutput() {
		return output;
	}

	public void setErrorThreshold(double min, double max) {
		errorMax = max;
		errorMin = min;
	}
}
