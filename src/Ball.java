import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class Ball extends JLabel {

    static final int BALL_WIDTH = 20;
    static final int BALL_HEIGHT = 20;
    final static int BASIC_VEL = 7;
    static int CX = 10;
    static int CY = 10;
    private static int originalCX;
    private static int originalCY;
    public static Integer[] possibleSpeedX = {-10,10};
    public static Integer[] possibleSpeedY = {-10,10};
    
    static java.util.Random random = new java.util.Random();

    private int diameter;
    private Color ballColor;

    public Ball(int diameter, Color ballColor) {
        this.diameter = diameter;
        this.ballColor = ballColor;
        this.setPreferredSize(new Dimension(diameter, diameter));
        this.setOpaque(true);
        this.setBackground(ballColor);
        getRandomSpeed(possibleSpeedX,possibleSpeedY);
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

    public static void freezeBall()
    {
        Integer[] freezeSpeed = {0};
        originalCX = CX;
        originalCY = CY;
        Ball.getRandomSpeed(freezeSpeed, freezeSpeed);
    }

    public static void unfreezeBall()
    {
        CX = originalCX;
        CY = originalCY;
    }

    public static void getRandomSpeed(Integer[] speedArrX, Integer[] speedArrY)
    {
        CX = speedArrX[random.nextInt(speedArrX.length)];
        CY = speedArrY[random.nextInt(speedArrY.length)];
    }

    public void centerBall() {
        this.setBounds(520, 300, BALL_WIDTH, BALL_HEIGHT);
        getRandomSpeed(possibleSpeedX,possibleSpeedY);
    }

    public void bounceOffEdges() {
        if (this.getX() <= 0) {
            Game.loose = true;
        }

        else if (this.getX() >= Window.getSCREEN_WIDTH() - 2 * BALL_WIDTH) {
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

    // getters and setters

    public static int getBallWidth() {
        return BALL_WIDTH;
    }

    public static int getBallHeight() {
        return BALL_HEIGHT;
    }

    public static void setPossibleSpeedX(Integer[] possibleSpeedX) {
        Ball.possibleSpeedX = possibleSpeedX;
    }

    public static void setPossibleSpeedY(Integer[] possibleSpeedY) {
        Ball.possibleSpeedY = possibleSpeedY;
    }

}
