package view;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenu extends JPanel {
	   public static Icon pvpI = new ImageIcon("images/2players.png");
       public static Icon highscoresI = new ImageIcon("images/highscores.png");
       public Icon exitI = new ImageIcon("images/exit.png");
       public Icon ohtelloI = new ImageIcon("images/othello.png");
       public Icon start = new ImageIcon("images/startgame.png");
       public Icon pvcI = new ImageIcon("images/vscomputer.png");
       
	public MainMenu(){
		super();
        setLayout(new BorderLayout());

        this.setBackground(Color.darkGray);
        JLabel startGame = new JLabel();
        JLabel exit= new JLabel();
        
        exit.addMouseListener( new MouseAdapter() {
        	public void mouseClicked(MouseEvent me) {
        		System.exit(0);
        	}
        });
        
        JLabel othello= new JLabel();
        JLabel highscores= new JLabel();
        JPanel centre= new JPanel(new GridLayout(2,1));
        centre.setBackground(Color.darkGray);
        JLabel pvp = new JLabel();
        pvp.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent me){
        		try {
					Othello.main(new String[]{"0"});
					frame.setVisible(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	
        });
      
        JLabel pvc = new JLabel();
        pvc.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent me){
        		try {
					Othello.main(new String[]{"1"});
					frame.setVisible(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	
        });
        
        othello.setIcon(ohtelloI);
        highscores.setIcon(highscoresI);
        exit.setIcon(exitI);
        startGame.setIcon(start);
        pvp.setIcon(pvpI);
        pvc.setIcon(pvcI);
        centre.add(pvp);
        centre.add(pvc);
        othello.setHorizontalAlignment( SwingConstants.CENTER );
        exit.setHorizontalAlignment( SwingConstants.CENTER );
        this.add(startGame, BorderLayout.WEST);
        this.add(exit,BorderLayout.SOUTH);
        this.add(othello,BorderLayout.NORTH);
        this.add(highscores,BorderLayout.EAST);
        this.add(centre);
		
	}
	 static JFrame frame = new JFrame("Main Menu");
	public static void main(String [] args){
	
	        MainMenu main = new MainMenu();

	        frame.setUndecorated(true); // Remove title bar
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



	        frame.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent windowEvent) {
	                super.windowClosing(windowEvent);
	                System.exit(0);
	            }
	        });
	        frame.setResizable(false);
	        frame.getContentPane().add(main);
	        frame.pack();
	        Splash.centreWindow(frame);
	        frame.setVisible(true);
	    }
	

		
}


