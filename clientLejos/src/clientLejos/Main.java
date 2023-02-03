package clientLejos;

import java.io.IOException;
import java.net.UnknownHostException;

public class Main {
    
    public static void main(String[] args) throws UnknownHostException, IOException {

        Client client = new Client();
        Controller controller = new Controller();

        controller.gestisciController();
        
        client.connessione();

        while (true) {

            client.mandaMessaggio(controller.getValue());

            try {
                Thread.sleep(180);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                client.chiudiConnessione();
            }
            
            client.riceviMessaggio();
            
            controller.setVeloc(client.getVel());

        }
    }
}

