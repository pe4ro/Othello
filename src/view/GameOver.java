package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * User: Amandine Eap & Jyothis George
 * Date: 19/05/14
 */
public class GameOver extends JFrame {

    private final Icon othelloLogo = new ImageIcon("images/logo-29_sml.png");
    private final Icon gameOverLogo = new ImageIcon("images/menu/gameOver.png");
    private final Icon playAgainLogo = new ImageIcon("images/menu/playAgain.png");
    private final Icon highestScoreLogo = new ImageIcon("images/menu/highestScore.png");
    private final Icon quitLogo = new ImageIcon("images/menu/quit.png");

    
    public static void main(String[] args) {
        new GameOver().start();
    }

    private void start() {
        setUndecorated(true); // Remove title bar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        setBackground(Color.DARK_GRAY);
        
        
        pack();
        centreWindow(this);
        setVisible(true);
        
        Othello othello = new Othello();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
                System.exit(0);
            }
        });
        
        othello.refreshOthello();
        setResizable(false);
    }

    private void addComponentsToPane(Container contentPane) {
        
        JPanel panelContainer = new JPanel(new BorderLayout());
        Border b = BorderFactory.createLineBorder(Color.WHITE,5);
        panelContainer.setBorder(b);
        
        JPanel panelTop = new JPanel(new GridLayout(0,1));
        JPanel panelMiddle = new JPanel(new GridLayout(0,1));
        JPanel panelBottom = new JPanel(new GridLayout(0,1));
        
        JLabel gameOverLabel = new JLabel(gameOverLogo);
        gameOverLabel.setBorder(new EmptyBorder(10,0,25,0));

        JLabel othelloLogoLabel = new JLabel(othelloLogo);
        othelloLogoLabel.setBorder(new EmptyBorder(0,0,25,0));

        JLabel playAgainLabel = new JLabel(playAgainLogo);
        JLabel highestScoreLabel = new JLabel(highestScoreLogo);
        highestScoreLabel.setBorder(new EmptyBorder(0,10,0,0));
        JLabel quitLabel = new JLabel(quitLogo);
        
        panelTop.add(gameOverLabel);
        panelTop.setBackground(Color.darkGray);
        
        panelMiddle.add(othelloLogoLabel);
        panelMiddle.setBackground(Color.darkGray);
        
        panelBottom.add(playAgainLabel);
        panelBottom.add(highestScoreLabel);
        panelBottom.add(quitLabel);
        panelBottom.setBackground(Color.darkGray);
        
        panelContainer.add(panelTop, BorderLayout.NORTH);
        panelContainer.add(panelMiddle, BorderLayout.CENTER);
        panelContainer.add(panelBottom, BorderLayout.SOUTH);
        
        getContentPane().add(panelContainer);
        
        playAgainLabel.addMouseListener(new MouseAdapter(){  // to main menu
            
            @Override
            public void mouseClicked(MouseEvent e){ 
                MainMenu.main(null);
                setVisible(false);
                
                
                
            }
            
       });  
        
        highestScoreLabel.addMouseListener(new MouseAdapter(){  
               
            public void mouseClicked(MouseEvent e){ 
                
                /* @OverridesetVisible(false);
                
                try {
                    
                } catch (IOException ex) {
                    Logger.getLogger(GameOver.class.getName()).log(Level.SEVERE, null, ex);
                }
                        */
                
            }
            
       }); 
           
        quitLabel.addMouseListener(new MouseAdapter(){  
            
            @Override
            public void mouseClicked(MouseEvent e){ 
                
                setVisible(false);
                
                System.exit(0);
            }
            
       }); 
            
        
    }


    public static void centreWindow(JFrame frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }


}