package clientLejos;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client {

    private Socket clientSocket;
    private DataOutputStream output;
    private BufferedReader input;
    private String vel = "0";

    public void connessione() throws UnknownHostException, IOException {
        String nomeServer = JOptionPane.showInputDialog("Inserisci l'indirizzo del server");
        String portaServer = JOptionPane.showInputDialog("Inserisci la porta del server");

        int porta = Integer.parseInt(portaServer);

        clientSocket = new Socket(nomeServer, porta);
    }

    public void mandaMessaggio(char msg) throws IOException {

        output = new DataOutputStream(clientSocket.getOutputStream());

        //invio char lettera
        output.writeChar(msg);
    }

   
    
    public String getVel() {
    	
    	return this.vel;
    }

    public void chiudiConnessione() throws IOException {

        clientSocket.close();
        output.close();
        input.close();
    }
    public void riceviMessaggio() throws IOException {

        //ricezione dati dal server
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        
        vel = input.readLine();
    }
}

