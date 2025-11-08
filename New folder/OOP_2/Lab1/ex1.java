import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ex1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Guess number game");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel nrLabel = new JLabel("Guess number(1 to 100)");
        JTextField nrField = new JTextField(5);
        nrField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume();
                }
            }
        });
        JButton btn = new JButton("Guess");

        frame.add(nrLabel);
        frame.add(nrField);
        frame.add(btn);
        frame.setVisible(true);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessNr(nrField);
                nrField.setText("");
            }
        });
    }

    public static void guessNr(JTextField nrField) {
        int nrFieldValue = Integer.parseInt(nrField.getText().trim());

        int randomNr = (int) (Math.random() * 100) + 1;

        String message;
        if (nrFieldValue > 0 && nrFieldValue <= 1000) {
            if (nrFieldValue == randomNr) {
                message = "You won!";
                System.out.println("You won!");
            } else if (nrFieldValue > randomNr) {
                message = "The number entered is too large";
                System.out.println("The number entered is too large");
            } else {
                message = "The number entered is too small";
                System.out.println("The number entered is too small");
            }
        } else {
            message = "Insert a number form 1 to 1000";
        }

        JOptionPane.showMessageDialog(null, message);
        System.out.println("Random number is:" + randomNr);
        System.out.println("The number you inserted is:" + nrFieldValue);
    }
}