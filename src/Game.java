import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

enum GameState {
    MENU, PLAY, PAUSE;
}

public class Game implements KeyListener {
    private Timer timer;

    private Player playerOne;
    private Player aiBot;
    private Ball ball;
    private Window window;
    private static GameState state;

    private static int ballStartingX = (Window.getSCREEN_WIDTH() / 2) - Ball.getBallWidth();
    private static int ballStartingY = Window.getSCREEN_HEIGHT() / 2 - Ball.getBallHeight() / 2;

    public static int score = 0;
    public static boolean win = false;
    public static boolean loose = false;

    public static int currentDifficulty = -1; // default

    public Menu menu = new Menu();

    private MainLabel scoreLabel = new MainLabel("Score: 0");
    private MainLabel looseLabel = new MainLabel("You lost :(");
    private MainLabel descriptiveLooseLabel = new MainLabel("Press 'R' to restart");

    Game() {
        window = new Window();
        window.addKeyListener(this);
        state = GameState.MENU;
        menu.addLabelsToContainer(window.getContentPane());
        initializeComponents();
    }

    public void initializeComponents() {
        playerOne = new Player();
        aiBot = new Player();
        ball = new Ball(10, Color.RED);

        playerOne.addToComponent(70, 270, window);
        aiBot.addToComponent(980, 270, window);
        ball.addToComponent(ballStartingX, ballStartingY, window);

        scoreLabel.setForeground(Color.YELLOW);
        scoreLabel.setFont(new Font("Serif", Font.BOLD, 20));
        scoreLabel.addToComponent(500, 0, window);

        looseLabel.setForeground(Color.RED);
        looseLabel.setFont(new Font("Serif", Font.BOLD, 40));

        descriptiveLooseLabel.setForeground(Color.RED);
        descriptiveLooseLabel.setFont(new Font("Serif", Font.ITALIC, 20));
    }

    public void run() {
            this.update();
    }

    public void update() {
        timer = new Timer(20, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(state==GameState.PLAY){
                Menu.hideMenu();
                Difficulty.setDifficultyVelocities(currentDifficulty);

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
                    looseLabel.addToComponent(450, 240, window);
                    descriptiveLooseLabel.addToComponent(460, 280, window);
                    looseLabel.setVisible(true);
                    descriptiveLooseLabel.setVisible(true);
                }
            }}
        });

        timer.start();
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
    public void keyPressed(KeyEvent e) {
        if(state==GameState.PLAY){
        playerOne.move(e);

         if (e.getKeyChar() == 'r') {
            if (loose == true) {
                ball.centerBall();
                timer.stop();
                this.update();
                score = 0;
                scoreLabel.updateScore();
                looseLabel.setVisible(false);
                descriptiveLooseLabel.setVisible(false);
                loose = false;
            }
        }}

        if (e.getKeyCode() == 27) {
            window.setVisible(false);
            window.dispose();
            timer.stop();
        }
    }

    // getters and unused Overrides
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

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static int getCurrentDifficulty() {
        return currentDifficulty;
    }

    public static void setCurrentDifficulty(int newDiff) {
        currentDifficulty = newDiff;
    }

    public static void setState(GameState state) {
        Game.state = state;
    }

    public static GameState getState() {
        return state;
    }

}
