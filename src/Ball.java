import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class Ball extends JLabel {

    static final int BALL_WIDTH = 20;
    static final int BALL_HEIGHT = 20;
    final static int BASIC_VEL = 7;
    int CX = 10;
    int CY = 10;
    Integer[] possibleSpeedX = {-10,10,-11,11};
    Integer[] possibleSpeedY = {-9,9,-10,10,-11,11};
    java.util.Random random = new java.util.Random();

    private int diameter;
    private Color ballColor;

    public Ball(int diameter, Color ballColor) {
        this.diameter = diameter;
        this.ballColor = ballColor;
        this.setPreferredSize(new Dimension(diameter, diameter));
        this.setOpaque(true);
        this.setBackground(ballColor);
        getRandomSpeed();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(ballColor);
        g.fillOval(0, 0, diameter, diameter);
    }

    public void addToComponent(int x, int y, JFrame component) {
        this.setBounds(x, y, BALL_WIDTH, BALL_HEIGHT);
        component.add(this);
    }

    public void moveBall(int x, int y) {
        this.setLocation(x, y);
    }

    public void getRandomSpeed()
    {
        CX = possibleSpeedX[random.nextInt(possibleSpeedX.length)];
        CY = possibleSpeedY[random.nextInt(possibleSpeedY.length)];
    }

    public void centerBall() {
        this.setBounds(520, 300, BALL_WIDTH, BALL_HEIGHT);
        getRandomSpeed();
    }

    public void bounceOffEdges() {
        if (this.getX() <= 0) {
            Game.loose = true;
            reverseX();
        }

        else if (this.getX() >= Window.getSCREEN_WIDTH() - 2 * BALL_WIDTH) {
            reverseX();
            Game.win = true;
        }

        if (this.getY() <= 0) {
            reverseY();
        }

        else if (this.getY() >= Window.SCREEN_HEIGHT - 3 * BALL_HEIGHT) {
            reverseY();
        }
    }

    public void reverseX() {
        CX *= -1;
    }

    public void reverseY() {
        CY *= -1;
    }

    // getters
    public int getX() {
        return super.getX();
    }

    public int getY() {
        return super.getY();
    }

    public static int getBallWidth() {
        return BALL_WIDTH;
    }

    public static int getBallHeight() {
        return BALL_HEIGHT;
    }
}
