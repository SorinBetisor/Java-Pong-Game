import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Game implements KeyListener {
    private Timer timer;

    private Player playerOne;
    private Player aiBot;
    private Ball ball;
    private Window window;

    private static int ballStartingX = (Window.getSCREEN_WIDTH() / 2) - Ball.getBallWidth();
    private static int ballStartingY = Window.getSCREEN_HEIGHT() / 2 - Ball.getBallHeight() / 2;

    public static int score = 0;
    public static boolean win = false;
    public static boolean loose = false;

    private Label scoreLabel = new Label("Score: 0");
    private Label looseLabel = new Label("You lost :(");
    private Label descriptiveLooseLabel = new Label("Press 'R' to restart");

    Game() {
        playerOne = new Player();
        aiBot = new Player();
        ball = new Ball(10, Color.RED);
        window = new Window();
        window.getFrame().addKeyListener(this);

        SwingUtilities.invokeLater(() -> {
            window.getFrame();
        });

        playerOne.addToComponent(70, 270, window.getFrame());

        aiBot.addToComponent(980, 270, window.getFrame());

        ball.addToComponent(ballStartingX, ballStartingY, window.getFrame());

        scoreLabel.setForeground(Color.YELLOW);
        scoreLabel.setFont(new Font("Serif", Font.BOLD, 20));
        scoreLabel.addToComponent(500, 0, window.getFrame());

        looseLabel.setForeground(Color.RED);
        looseLabel.setFont(new Font("Serif", Font.BOLD, 40));

        descriptiveLooseLabel.setForeground(Color.RED);
        descriptiveLooseLabel.setFont(new Font("Serif",Font.ITALIC,20));
    }

    public void run() {
        this.update();
        this.render();
    }

    public void update() {
        timer = new Timer(20, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ball.moveBall(ball.getX() + ball.CX, ball.getY() + ball.CY);
                ball.bounceOffEdges();
                if (checkCollisionWithPaddles(playerOne) || checkCollisionWithPaddles(aiBot)) {
                    ball.CX *= -1;
                }
                Player.botMove(aiBot, ball);

                if (win) {
                    score += 1;
                    scoreLabel.updateScore();
                    ball.centerBall();
                    win = false;
                }

                if (loose) {
                    ball.CX = 0;
                    ball.CY = 0;
                    Player.stopBot(aiBot);
                    looseLabel.addToComponent(450, 240, window.getFrame());
                    descriptiveLooseLabel.addToComponent(460, 280,window.getFrame());
                    looseLabel.setVisible(true);
                    descriptiveLooseLabel.setVisible(true);
                }
            }
        });

        timer.start();
    }

    public void render() {

    }

    public boolean checkCollisionWithPaddles(Player player) {
        if (ball.getX() > (player.getX() - Ball.getBallWidth())
                && ball.getX() < player.getX() + Player.getPlayerWidth()) {
            if (ball.getY() + Ball.getBallHeight() > player.getY()
                    && ball.getY() < player.getY() + Player.getPlayerHeight()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        playerOne.move(e);

        if (e.getKeyCode() == 27) {
            window.getFrame().setVisible(false);
            window.getFrame().dispose();
            timer.stop();
        } else if (e.getKeyChar() == 'r') {
            if (loose == true) {
                ball.centerBall();
                timer.stop();
                this.update();
                score=0;
                scoreLabel.updateScore();
                looseLabel.setVisible(false);
                descriptiveLooseLabel.setVisible(false);
                loose = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    // getters
    public static int getBallStartingY() {
        return ballStartingY;
    }

    public static int getBallStartingX() {
        return ballStartingX;
    }

    public static boolean isLoose() {
        return loose;
    }

    public static boolean isWin() {
        return win;
    }
}
