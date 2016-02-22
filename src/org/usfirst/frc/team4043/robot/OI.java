package org.usfirst.frc.team4043.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public static OI instance;
	public static Joystick driverStick, coStick;
	public static JoystickButton portcullis;
	public static JoystickButton openDoor;
	public static JoystickButton drawBridge;
	public static JoystickButton switchToManual;
	public static JoystickButton switchDirection;
	public static JoystickButton shootSolenoid;
	
	public static JoystickButton boulderPickerUpperUp;
	public static JoystickButton boulderPickerUpperDown;
	public static JoystickButton suckIn;
	public static JoystickButton suckOut;
	public static JoystickButton turnRight90;
	public static JoystickButton turnLeft90;
	
	public OI(){
		
		driverStick = new Joystick(0);
		coStick = new Joystick(1);
		
		portcullis= new JoystickButton(coStick, 4); //Y
		openDoor= new JoystickButton(coStick, 2); //B
		drawBridge= new JoystickButton(coStick, 3); //X
		switchToManual = new JoystickButton(coStick, 1); //A
		switchDirection = new JoystickButton(coStick, 5); //trigger Right
		shootSolenoid = new JoystickButton(coStick,6); //trigger left 
		
		boulderPickerUpperUp= new JoystickButton(driverStick, 4); //Y
		boulderPickerUpperDown= new JoystickButton(driverStick, 1); //A
		suckIn= new JoystickButton(driverStick, 3); //X
		suckOut = new JoystickButton(driverStick, 2); //B
		
		turnRight90 = new JoystickButton(driverStick, 5); 
		turnLeft90 = new JoystickButton(driverStick, 4);

	}
	public static OI getInstance(){
		if(instance == null){
			instance = new OI();
			}
		return instance;
		}
}

