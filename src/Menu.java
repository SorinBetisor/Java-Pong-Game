import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class Menu extends Container {

    private final int BUTTON_HEIGHT = 50;
    private final int BUTTON_WIDTH = 200;

    private static JLabel selectLabel = new JLabel("Select difficulty:");
    private static JButton easyButton = new JButton("EASY", null);
    private static JButton mediumButton = new JButton("MEDIUM", null);
    private static JButton hardButton = new JButton("HARD", null);

    Menu() {
        easyButton.setFocusable(false);
        mediumButton.setFocusable(false);
        hardButton.setFocusable(false);

        setMenuFont(selectLabel);
        setMenuFont(easyButton);
        setMenuFont(mediumButton);
        setMenuFont(hardButton);

        selectLabel.setForeground(Color.WHITE);
        easyButton.setForeground(Color.GREEN.darker());
        mediumButton.setForeground(Color.ORANGE);
        hardButton.setForeground(Color.RED.darker());

        selectLabel.setBounds(400, 150, 500, BUTTON_HEIGHT);
        easyButton.setBounds(440, 250, BUTTON_WIDTH, BUTTON_HEIGHT);
        mediumButton.setBounds(440, 350, BUTTON_WIDTH, BUTTON_HEIGHT);
        hardButton.setBounds(440, 450, BUTTON_WIDTH, BUTTON_HEIGHT);

        addClickListener();
    }

    private void setMenuFont(JComponent label) {
        label.setFont(new Font("SansSerif", Font.BOLD, 40));
    }

    public void addLabelsToContainer(Container container) {
        container.add(selectLabel);
        container.add(easyButton);
        container.add(mediumButton);
        container.add(hardButton);
    }

    public void addClickListener() {
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.setCurrentDifficulty(0);
                Game.setState(GameState.PLAY);
            }
        });
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.setCurrentDifficulty(1);
                Game.setState(GameState.PLAY);
            }
        });
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.setCurrentDifficulty(2);
                Game.setState(GameState.PLAY);
            }
        });
    }

    public static void hideMenu() {
        selectLabel.setVisible(false);
        easyButton.setVisible(false);
        mediumButton.setVisible(false);
        hardButton.setVisible(false);
    }

}
