
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ex4 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Learn multiplication");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel initalLabel = new JLabel("How much is ");
        JLabel timesLabel = new JLabel(" X ");

        JLabel firstNr = new JLabel(generateRandomNumber() + "");
        JLabel secondNr = new JLabel(generateRandomNumber() + "");

        JTextField nrField = new JTextField(5);
        JButton btn = new JButton("Answer");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = nrField.getText();
                int firstNumber = Integer.parseInt(firstNr.getText());
                int secondNumber = Integer.parseInt(secondNr.getText());
                int correctAnswer = firstNumber * secondNumber;

                if (!userInput.isEmpty() && Integer.parseInt(userInput) == correctAnswer) {
                    JOptionPane.showMessageDialog(frame, "Correct!");
                    firstNr.setText(generateRandomNumber() + "");
                    secondNr.setText(generateRandomNumber() + "");
                } else {
                    JOptionPane.showMessageDialog(frame, "Incorrect!");
                }
            }
        });

        frame.add(initalLabel);
        frame.add(firstNr);
        frame.add(timesLabel);
        frame.add(secondNr);
        frame.add(nrField);
        frame.add(btn);

        frame.setVisible(true);
    }

    private static int generateRandomNumber() {
        return (int) (Math.random() * 10 + 1);
    }
}
