import javax.swing.JFrame;
import javax.swing.JLabel;

public class Label extends JLabel 
{
    private int labelWidth = 200;
    private int labelHeight = 100;
    private static String currentText;

    Label(String text)
    {
        this.setText(text);
        currentText = text;
    }
    public void updateScore()
    {
        currentText = String.format("%s %d","Score:",Game.score);
        this.setText(currentText);
    }

      
    public void addToComponent(int x,int y,JFrame component)
    {
        this.setBounds(x,y,labelWidth,labelHeight);
        component.add(this);
    }

}
