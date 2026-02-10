import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountFrame extends JFrame {
    private JTextField t1, t2, t3, t4;
    private JButton b;

    public CreateAccountFrame() {
        super("the Craeta Account Window");
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("PNC"));
        t1 = new JTextField(10);
        add(t1);

        add(new JLabel("Password"));
        t2 = new JTextField(10);
        add(t2);

        add(new JLabel("Email address"));
        t3 = new JTextField(10);
        add(t3);

        b = new JButton("Create Account");
        add(b);
        var ml = new MyListener();
        b.addActionListener(b);
    }

    private class MyListener implements ActionListener {

        public void actionPerformed(ActionEvent e){
            t1.setBackground(null);
            t2.setBackground(null);
            t3.setBackground(null);
            t4.setBackground(null);

            if(FieldType.SS.verifyText(t1.getText()) == false) t1.setBackground(Color.RED);
            else t1.setText(FieldType.SS.getContent());
        }

    }
}
