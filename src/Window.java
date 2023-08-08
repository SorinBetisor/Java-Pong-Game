import javax.swing.*;
import java.awt.Color;

public class Window extends JFrame {

    final static int SCREEN_HEIGHT = 720;
    final static int SCREEN_WIDTH = 1080;   


        Window() {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
            this.setLayout(null);
            this.setLocationRelativeTo(null);
            this.getContentPane().setBackground(Color.BLACK);
            this.setTitle("Pong");
            this.setVisible(true); 
        }

    public static int getSCREEN_HEIGHT() {
        return SCREEN_HEIGHT;
    }

    public static int getSCREEN_WIDTH() {
        return SCREEN_WIDTH;
    }
    
    public Window getFrame() {
        return this;
    }
}
