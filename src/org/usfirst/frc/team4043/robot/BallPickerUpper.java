package org.usfirst.frc.team4043.robot;

import edu.wpi.first.wpilibj.command.Command;

public class BallPickerUpper extends Command {
	public int upOrDown;

	public BallPickerUpper() {
		upOrDown = 1;
	}

	public BallPickerUpper(int x) {
		upOrDown = 2;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		System.out.println("Command Running " + RobotMap.limitLift);
		if (upOrDown == 2) { // go UP
			System.out.println("alkeghliaeurrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrru" + RobotMap.limitLift);
			if (!(RobotMap.limitLift.equals(1))) {
				RobotMap.ballUpMotor.set(0.25);
			} else if (RobotMap.limitLift.equals(1)) {
				RobotMap.ballUpMotor.set(0);
			}
		} else if (upOrDown == 1) { // go DOWN
			System.out.println("alkeghliaeurrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrru" + RobotMap.limitLower);
			if (!(RobotMap.limitLower.equals(1))) {
				RobotMap.ballUpMotor.set(-0.25);
			} else if (RobotMap.limitLower.equals(1)) {
				RobotMap.ballUpMotor.set(0);
			}
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
