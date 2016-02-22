package org.usfirst.frc.team4043.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Vision {

	
	public static Vision instance;
	private double[] areas, centerY, centerX, height, width, defaultValue;
	private double theta, yPixelDisplacement, dtt, distance;
	public NetworkTable table;
	
    public static final int X_MAX = 480;
	public static final int X_MIN = 0;
	public static final int Y_MAX = 360;
	public static final int Y_MIN = 0;
	public static final double FOCAL_X = 360;
	public static final double FOCAL_Y = 247.7;
	
	public static final int X_MIN_BOUND = 0;
	public static final int Y_MAX_BOUND = 240;
	public static final int Y_MIN_BOUND = 0;
	public static final int HALF_Y_MAX_BOUND = Y_MAX_BOUND/2;
	
	//Camera Variables
		public static final double CAMERA_VIEW_WIDTH_DEGREES = 63;
		public static final double CAMERA_VIEW_HEIGHT_DEGREES = 51;
		public static final double HALF_CV_HEIGHT_DEGREES = CAMERA_VIEW_HEIGHT_DEGREES/2;
		public static final double HALF_CV_HEIGHT_RADIANS = Math.toRadians(HALF_CV_HEIGHT_DEGREES);
			//placeholder
		public static final double ANGLE_FROM_GROUND = 36;
		public static final double ANGLE_FROM_GROUND_RADIANS = Math.toRadians(ANGLE_FROM_GROUND);
		
		// Actual Distances
		public static final int HEIGHT_ACTUAL = 12; //Tape
		public static final int WIDTH_ACTUAL = 20;  //Tape
		public static final double TARGET_CENTER_HEIGHT_FEET = 8.08 - (32/12);
	
	public static Vision getInstance() {
		if (instance == null) {
			instance = new Vision();
		}
		return instance;
	}
	
	public Vision() {
		table = NetworkTable.getTable("SmartDashboard");
		defaultValue = new double[0];
		centerX = new double[defaultValue.length];
		centerY = new double[defaultValue.length];
		height = new double[defaultValue.length];
	}
	public boolean alignCheck() {
		centerX = table.getNumberArray("centerX", defaultValue);
		centerY = table.getNumberArray("centerY", defaultValue);
		
		for (int i = 0; i <centerY.length; i++) {
			if (centerY[i] <= Y_MAX && centerY[i] >= Y_MIN && centerX[i] <= X_MAX && centerX[i] >= X_MIN ) {
				return true;
			}
		}
	return false;
	}
	
	public double getDistance(){
		table = NetworkTable.getTable("SmartDashboard");
		width = table.getNumberArray("width", defaultValue);
		distance = FOCAL_X*WIDTH_ACTUAL/width[0];
		//System.out.println("Width is reported as: " + width[0] + " pixels");
		//System.out.println("Robot is: " + distance/12 + " feet away - BY WIDTH");
		SmartDashboard.putNumber("Distance Recorded as: ", distance/12);
		return distance/12;
	}
	
	public void angleAdjust(){
	//	System.out.println("set angle to: " + camAngle.get());
	//	camAngle.set(OI.getInstance().getStick().getCubeZ());
	}
	
	public void setCamAngle(double angle){
	//	camAngle.set(angle);
		System.out.println("Angle set to " + angle + " degrees.");
	}
	
	public void visualize(){
		table = NetworkTable.getTable("SmartDashboard");
		
		double[] defaultValue = new double[0];
		areas = table.getNumberArray("area", defaultValue);
		System.out.println("areas: ");
		for (double area : areas) {
			System.out.println(area + " ");
			
		}
		centerY = table.getNumberArray("centerY", defaultValue);
		System.out.println("centerY: ");
		for (double centersY : centerY) {
			System.out.println(centersY + " ");
		}
		centerX = table.getNumberArray("centerX", defaultValue);
		System.out.println("centerX: ");
		for (double centersX : centerX) {
			System.out.println(centersX + " ");
		}
		height = table.getNumberArray("height", defaultValue);
		System.out.println("height: ");
		for (double heights : height) {
			System.out.println(heights + " ");
		}
		width = table.getNumberArray("width", defaultValue);
		System.out.println("width: ");
		for (double widths : width) {
			System.out.println(widths + " ");
		}
		System.out.println();	

	}
	
	/**************************************************************************************************
	 * Find distance by similar triangles and trig
	 * Should work, doesn't right now for some reason
	 * Need to figure out how to find theta
	 **************************************************************************************************/
	public double getDistanceToTarget(int index){
	height = table.getNumberArray("height", defaultValue);
	centerY = table.getNumberArray("centerY", defaultValue);
		
	yPixelDisplacement = height[index] - centerY[index];
	
	theta = Math.atan((yPixelDisplacement/HALF_Y_MAX_BOUND)*Math.tan(HALF_CV_HEIGHT_RADIANS));
	dtt = TARGET_CENTER_HEIGHT_FEET/(Math.tan(ANGLE_FROM_GROUND_RADIANS + theta));
	
	System.out.println("Robot is " + dtt + " feet away from the tower.");
	
	return dtt;
	}
	
	public void testing(){
		height = table.getNumberArray("height", defaultValue);
		System.out.println("height is: " + height[defaultValue.length]);
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
}
