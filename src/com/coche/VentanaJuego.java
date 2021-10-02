package com.coche;


import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class VentanaJuego {
	public static void main(String[] args) throws IOException {
		JFrame f = new JFrame( "Coche" );
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.getContentPane().setLayout( null );
		f.setSize( 800, 800 );
		f.setLocation( 0, 0 );
		
		CocheFisicas coche = new CocheFisicas(0.2,2.);
		coche.setImage(ImageIO.read(VentanaJuego.class.getResource("coche.png")));
		coche.setSize(100,100); 
		coche.setBounds( 0, 0, 100, 100 );
		
		f.getContentPane().add( coche );
		
		KeyHandler handler=new KeyHandler();
		f.addKeyListener(handler);
		
		coche.setHorizontalAlignment(0);
		coche.setVerticalAlignment(0);
		f.setVisible( true );
		JOptionPane.showMessageDialog(f, "Usa las flechas o WASD para mover el coche.");
		
		Thread t = new Thread() {
				public void run() {
					while(true){
						double up=handler.keyUp()?1:0;
						double down=handler.keyDown()?1:0;
						double left=handler.keyLeft()?1:0;
						double right=handler.keyRight()?1:0;
						
						for(int i=0;i<2;i++)coche.update(500*(up-down),0.05*(right-left));
						
						coche.draw();
						try {
							Thread.sleep(1000/60);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
		};
		t.setDaemon(true);
		t.start();
	}
}