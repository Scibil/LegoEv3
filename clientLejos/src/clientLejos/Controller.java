package clientLejos;


//importing awt libraries  

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*; 

public class Controller {

 private char value;
 private int veloc = 0;

 JFrame frame = new JFrame("Telecomando");
 final JPanel panel = new JPanel();
 final JLabel label = new JLabel();

 final JLabel label2 = new JLabel("Avanti: W,  Indietro: S, Sinistra: A, Destra: D, Freno: J, Spegni: P");

 
 
 
 public void gestisciController() {

 	frame.setSize(1000,1000);
    
 	
 	panel.add(label);
     panel.add(label2);
     
     
     label2.setSize(1200,1000);
     label2.getWidth();
 	
 	label.setHorizontalAlignment(JLabel.RIGHT);
     label.setVerticalAlignment(JLabel.BOTTOM);
 	label2.setHorizontalAlignment(JLabel.CENTER);
     label2.setVerticalAlignment(JLabel.CENTER);

     
     
     frame.setLayout(new BorderLayout());

     frame.add(panel);
     frame.pack();
     frame.setVisible(true);

     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     

     frame.addKeyListener( new KeyListener() {

         public void keyTyped(KeyEvent e) {
         	label.setText("Velocità: " + veloc);
         }
     
         public void keyPressed(KeyEvent e) {
             value = e.getKeyChar();
         }
         public void keyReleased(KeyEvent e) {
             value = '0';
         }
     });

     frame.add(panel);

 }

 public char getValue() {
     return this.value;
 }
 
 public void setVeloc(String vel) {
 	
 	veloc = Integer.parseInt(vel);
 }
}