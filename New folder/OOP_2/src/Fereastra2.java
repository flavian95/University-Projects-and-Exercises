
package p2;

import javax.swing.*;
import java.awt.*;

public class Fereastra2 extends JFrame {

    private JPanel contentPane;
    private JPanel firstPane;
    private JPanel secondPane;
    private JPanel thirdPane;

    public Fereastra2() {
        super("Fereastra");

        contentPane = new JPanel();

        firstPane = new JPanel();
        secondPane = new JPanel();
        thirdPane = new JPanel();

        firstPane.setBackground(Color.BLUE);
        secondPane.setBackground(Color.GREEN);
        thirdPane.setBackground(Color.RED);

        firstPane.setSize(100, 100);
        secondPane.setSize(100, 100);
        thirdPane.setSize(100, 100);

        contentPane.setLayout(new GridLayout(3, 1));

        contentPane.add(firstPane);
        contentPane.add(secondPane);
        contentPane.add(thirdPane);

        Semafor s = new Semafor();

        add(contentPane);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Semafor s = new Semafor();
        s.schimbaCuloare();
        repaint();
    }

    public static void main(String[] args) {
        Fereastra frame = new Fereastra();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 600);
    }
}
