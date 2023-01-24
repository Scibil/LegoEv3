import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;


public class Start {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		LCD.drawString("forza torino!!!",0,4);
		try {
			Thread.sleep(5000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		Button.LEDPattern(4);
		
		/*Sound.beepSequence();
		Sound.playTone(2, 1);
		Sound.playTone(4, 1);
		
        // create two motor objects to control the motors.
        UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
        UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);
        
        motorA.setPower(40);
        motorB.setPower(40);
        
        motorA.forward();
        motorB.forward();
        
        motorA.stop();
        
        motorB.stop();
        
        motorA.close();
        
        motorB.close();*/
		UnregulatedMotor motorC = new UnregulatedMotor(MotorPort.C);
        UnregulatedMotor motorB = new UnregulatedMotor(MotorPort.B);

        // set motors to 50% power.
        motorC.setPower(50);
        motorB.setPower(50);

        // wait 2 seconds.
        Delay.msDelay(2000);

        // stop motors with brakes on. 
        motorC.stop();
        motorB.stop();

        // free up motor resources. 
        motorC.close(); 
        motorB.close();
 
        Sound.beepSequence(); // we are done.
		
	}
}
