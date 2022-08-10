import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        ImagePanel imagePanel = new ImagePanel();
        window.setSize(600, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(imagePanel);

        window.setVisible(true);

        ActionListener moveImage = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               imagePanel.repaint();
            }
        };

        Timer speedTimer = new Timer(3,moveImage);
        speedTimer.start();
    }
}
