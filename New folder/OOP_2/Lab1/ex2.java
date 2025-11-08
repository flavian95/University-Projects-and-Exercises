import javax.swing.*;
import java.awt.*;

public class ex2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("A font layout");
        frame.setSize(250, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField textBox = new JTextField("Changing the style of a text", 20);
        textBox.setFont(new Font("SansSerif", Font.PLAIN, 12));
        frame.add(textBox);

        JRadioButton option1 = new JRadioButton("Normal");
        JRadioButton option2 = new JRadioButton("Italic");
        JRadioButton option3 = new JRadioButton("Bold");
        JRadioButton option4 = new JRadioButton("Bold & Italic");

        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        frame.add(option1);
        frame.add(option2);
        frame.add(option3);
        frame.add(option4);

        frame.setVisible(true);

        option1.addActionListener(e -> textBox.setFont(new Font("SansSerif", Font.PLAIN, 12)));
        option2.addActionListener(e -> textBox.setFont(new Font("SansSerif", Font.ITALIC, 12)));
        option3.addActionListener(e -> textBox.setFont(new Font("SansSerif", Font.BOLD, 12)));
        option4.addActionListener(e -> textBox.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12)));
    }
}