
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;

    public Main() {
        super("Fereastra Principala");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1 = new JButton("Creeaza cont");
        b2 = new JButton("Cauta cont");
        b3 = new JButton("Login");
        b4 = new JButton("Sterge cont");
        b5 = new JButton("Modifica parola");

        JPanel p1 = new JPanel(new GridLayout(1, 5, 20, 10));
        // p1.setPreferredSize(new Dimension(200, 100));
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        add(p1, BorderLayout.NORTH);

        b1.addActionListener(new Ascultator());
    }

    public class Ascultator implements ActionListener {

        private JFrame f;

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1) {
                f = new CreeazaContFereastra();
                f.pack();
                f.setVisible(true);
                f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            } else if (e.getSource() == b2) {

            }
        }
    }

    public static void main(String[] args) {
        var f = new Main();
        f.pack();
        //f.setSize(700, 200);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}