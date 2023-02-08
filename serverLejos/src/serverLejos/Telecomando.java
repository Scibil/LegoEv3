package serverLejos;

import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import lejos.hardware.*;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;


public class Telecomando {
	RegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.B);
	RegulatedMotor motorB = new EV3LargeRegulatedMotor(MotorPort.C);
	RegulatedMotor motorC = new EV3LargeRegulatedMotor(MotorPort.A);
	
	
	
	private int maxVel = 1000;
	private int vel;
	private int i = 0;
	private int midVel;

	public void vaiIndietro() 
	{
		setVel();	
		motorA.setSpeed(1000);
		motorB.setSpeed(1000);
		motorA.backward();
		motorB.backward();
		Sound.beepSequence();
		if (getMidVel() < 850) {
			i = i+20;
			aumVel(i);
		}
		vel = motorA.getSpeed();
	}
	
	public void vaiAvanti() 
	{
		setVel();
		motorA.setSpeed(1000);
		motorB.setSpeed(1000);
		motorA.forward();
		motorB.forward();
		if (getMidVel() < 850) {
			i = i+20;
			aumVel(i);
		}
		vel = motorA.getSpeed();
			
	}
	
	public void stop()
	{
		motorA.stop(true);
		motorB.stop(true);
		vel = 0;
		
	}
	
	
	
	public void aumVel(int aum)
	{
		motorA.setSpeed(motorA.getSpeed()+aum);
		motorB.setSpeed(motorB.getSpeed()+aum);
		vel = getMidVel();
	}
	
	public void impVel(int vel)
	{
		motorA.setSpeed(vel);
		motorB.setSpeed(vel);
	}
	
	public void curvaSx() {
		
		motorA.setSpeed((int) (motorB.getSpeed()/1.55));
		motorA.forward();
		motorB.forward();
	}
	
	public void curvaDx() {
		
		
		motorB.setSpeed((int) (motorA.getSpeed()/1.55));
		motorA.forward();
		motorB.forward();
	}
	
	/*public void correggiDx() {
		
		
		motorB.setSpeed((int) (motorA.getSpeed()/1.15));
		motorA.forward();
		motorB.forward();
	}
	public void correggiSx() {
		
		
		motorA.setSpeed((int) (motorB.getSpeed()/1.15));
		motorA.forward();
		motorB.forward();
	}*/
	
	
	
	public void setVel() {
		
		motorA.setSpeed(vel);
		motorB.setSpeed(vel);
	}
	
	public void rallenta() {
		
			
			motorA.setSpeed(motorA.getSpeed() - 50);
			motorB.setSpeed(motorB.getSpeed() - 50);
		
	}
	
	public void shutDown() {
		
		motorA.stop(true);
		motorB.stop(true);
		
		motorA.close();
		motorB.close();
	}
	public void reset() {
		
		motorA.setSpeed(vel);
		motorB.setSpeed(vel);
		i = 0;
	}
	
	public int getMidVel() {
		
		midVel = (motorA.getSpeed() + motorB.getSpeed())/2;
		
		return midVel;
	}
	
}


