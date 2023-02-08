package serverLejos;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter output;
    private BufferedReader input;
    Telecomando muovi;
    
   
    
    public void startServer(int porta) throws IOException {
    	
        //creo un socket su porta 7777
        serverSocket = new ServerSocket(porta);

        System.out.println("Il server e' partito!");
        System.out.println("IP: 10.0.1.1");
        System.out.println("Porta: 7777");
        

        clientSocket = serverSocket.accept();

        System.out.println("Client connesso correttamente!");
    }

    public void riceviComandi() throws IOException {

    	muovi = new Telecomando();
    	
        output = new PrintWriter(clientSocket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (true) {
            char c = (char)input.read();
            
            switch (c)
            {
            
            case '0':
            	//System.out.println("rallenta");
            	muovi.rallenta();
            	break;
            	
            case 'w':
            	System.out.println("avanti");
            	muovi.vaiAvanti();
            	
            	break;
            	
            case 's':
            	System.out.println("indietro");
            	muovi.vaiIndietro();
            	break;
            	
            case 'a':
            	System.out.println("sinistra");
            	muovi.curvaSx();
            	break;
            	
            case 'd':
            	System.out.println("destra");
            	muovi.curvaDx();
            	break;
            	
            case 'j':
            	System.out.println("stop");
            	muovi.stop();
            	muovi.reset();
            	break;
            	
            case 'p':
            	System.out.println("Spegnimento server!");
            	muovi.shutDown();
            	stopServer();
            	break;
            
            /*case 'g':
            	System.out.println("correzione a destra");
            	muovi.correggiDx();
            	break;
            	
            case 'f':
            	System.out.println("correzione a sinistra");
            	muovi.correggiSx();
            	
            	break;*/
            }
            getMidVel();
        }
    }
    
    public void getMidVel() {
    	
    	//invio velocità al client
        output.println(muovi.getMidVel());
    	
    	
    }
    
    public void stopServer() throws IOException {
    	
    	clientSocket.close();
    	serverSocket.close();
    	output.close();
    	input.close();
    }

}
