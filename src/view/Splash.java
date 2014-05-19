package view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: lfmingo
 * Date: 15/05/14
 * Time: 15:17
 */
public class Splash extends JFrame {

    private Icon icono = new ImageIcon("images/logo-29.png");
    private Icon icono_loading = new ImageIcon("images/icon_loading.gif");



    public static void main(String[] args) {
        new Splash().start();
    }


    private void start() {
        setUndecorated(true); // Remove title bar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        setBackground(new Color(0, 0, 0, 0));
        pack();


        centreWindow(this);
        setVisible(true);

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                    Othello.main(null);
                    setVisible(false);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void addComponentsToPane(Container contentPane) {

        JPanel panel = new JPanel();
        panel.add(new JLabel(icono));
        panel.add(new JLabel(icono_loading));
        panel.setBackground(new Color(0, 0, 0, 0));
        getContentPane().add(panel);

    }


    public static void centreWindow(JFrame frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }


}
