package serverLejos;

import java.io.IOException;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Server server = new Server();

        server.startServer(7777);
        
        server.riceviComandi();
        
        server.getMidVel();
	}

}
