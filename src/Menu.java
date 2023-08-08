import java.awt.Color;
import java.awt.Container;
import java.awt.Font;


public class Menu extends Container {
    private int menuLabelWidth = 400;
    private int menuLabelHeight = 300;

    private Label selectLabel = new Label("Select difficulty:");
    private Label easyLabel = new Label("EASY");
    private Label mediumLabel = new Label("MEDIUM");
    private Label hardLabel = new Label("HARD");

    Menu() {
        setMenuFont(selectLabel);
        setMenuFont(easyLabel);
        setMenuFont(mediumLabel);
        setMenuFont(hardLabel);

        // selectLabel.setForeground(Color.WHITE);
        easyLabel.setForeground(Color.GREEN);
        mediumLabel.setForeground(Color.YELLOW);
        hardLabel.setForeground(Color.RED);

        // selectLabel.setBounds(300, 0, menuLabelWidth, menuLabelHeight);
        easyLabel.setBounds(400, 0, menuLabelWidth, menuLabelHeight);
        mediumLabel.setBounds(400, 200, menuLabelWidth, menuLabelHeight);
        hardLabel.setBounds(400, 400, menuLabelWidth, menuLabelHeight);

        addLabelsToContainer(this);
    }

    private void setMenuFont(Label label) {
        label.setFont(new Font("SansSerif", Font.BOLD, 60));
    }

    public void addLabelsToContainer(Container container) {
        // container.add(selectLabel);
        container.add(easyLabel);
        container.add(mediumLabel);
        container.add(hardLabel);
    }

}
