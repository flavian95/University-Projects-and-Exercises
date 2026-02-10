

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreeazaContFereastra extends JFrame {

    private JButton b1;
    private JButton b2;
    private JTextField t1;
    private JTextField t2;

    public CreeazaContFereastra() {
        super("Fereastra Creare Cont");

        JPanel p1 = new JPanel(new GridLayout(2, 2, 10, 10));
        p1.add(new JLabel("Username"));
        p1.add(t1 = new JTextField(15));

        p1.add(new JLabel("Password"));
        p1.add(t2 = new JTextField(15));

        JPanel p2 = new JPanel();
        p2.add(b1 = new JButton("Ok"));
        p2.add(b2 = new JButton("Cancel"));

        this.add(p1, BorderLayout.CENTER);
        this.add(p2, BorderLayout.SOUTH);
        Ascultator ascultator = new Ascultator();

        b1.addActionListener(ascultator);
        b2.addActionListener(ascultator);
    }

    public class Ascultator implements ActionListener {
        RepositoryManager rm = RepositoryManager.getInstance();

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                var b = rm.CreateAccount(new Account(t1.getText(), t2.getText()));

                if (b == true) {
                    JOptionPane.showMessageDialog(CreeazaContFereastra.this, "Contul a fost creat cu succes!");
                } else {
                    JOptionPane.showMessageDialog(CreeazaContFereastra.this, "Contul nu a fost creat cu succes!");
                }
            } else {
                CreeazaContFereastra.this.dispose();
            }
        }
    }
}
