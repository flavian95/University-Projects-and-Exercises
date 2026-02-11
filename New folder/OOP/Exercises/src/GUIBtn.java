
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIBtn {
    private JFrame frame;
    private JButton saveButton;
    private JButton exitButton;
    private JLabel nameLabel;
    private JTextField nameField;

    public GUIBtn() {
        frame = new JFrame("GUI Example");
        saveButton = new JButton("Save");
        exitButton = new JButton("Exit");
        nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(saveButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUIBtn();
            }
        });
    }
}
