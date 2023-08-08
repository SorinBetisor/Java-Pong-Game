import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends JLabel {
    static final int PLAYER_HEIGHT = 115;
    static final int BASIC_VEL = 7;
    static final int PLAYER_WIDTH = 15;
    static final int BOT_VEL = 9;

    Player() {
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
    }

    public void addToComponent(int x, int y, JFrame component) {
        this.setBounds(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
        component.add(this);
    }

    public void move(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w': {
                if (this.getY() > 0) {
                    this.setLocation(this.getX(), this.getY() - BASIC_VEL);
                }
            }
                break;

            case 's': {
                if (this.getY() < Window.getSCREEN_HEIGHT() - PLAYER_HEIGHT * 1.4) {
                    this.setLocation(this.getX(), this.getY() + BASIC_VEL);
                }
            }
                break;

        }

    }

    public static void botMove(Player bot, Ball ball) {
        if (bot.getY() < ball.getY()) {
            if (bot.getY() < Window.getSCREEN_HEIGHT() - PLAYER_HEIGHT * 1.4) 
            {
                bot.setLocation(bot.getX(), bot.getY() + BOT_VEL);
            }
        } else if (bot.getY() > ball.getY()) 
        {
            if(bot.getY()>0)
            {
            bot.setLocation(bot.getX(), bot.getY() - BOT_VEL);
        }
        }
    }

    public static void stopBot(Player bot)
    {
        bot.setLocation(980,270);
    }

    //getters

    public static int getPlayerHeight() {
        return PLAYER_HEIGHT;
    }

    public static int getPlayerWidth() {
        return PLAYER_WIDTH;
    }



}
