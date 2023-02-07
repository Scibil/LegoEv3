package serverLejos;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.net.Socket;
import org.junit.Test;

public class JunitTest {
  
  @Test
  public void testClientServerConnection() {
    int serverPort = 7777; // porta del server
    
    // Avviamo il server in un thread separato
    new Thread(() -> {
      try {
        Server server = new Server();
        server.startServer(7777);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }).start();
    
    // Diamo al server tempo di avviarsi
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    // Creiamo un client e verifichiamo che la connessione sia attiva
    try {
      Socket client = new Socket("localhost", serverPort);
      assertTrue(client.isConnected());
      client.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


