
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.List;

class Window2 extends Frame implements ActionListener {

    private Label nameLabel = new Label("Name");
    private TextField textName = new TextField(20);

    private Label sumLabel = new Label("Sum");
    private TextField sumText = new TextField(20);
    
    private Label accountNrLabel = new Label("Account Nr");
    private TextField accountNrText = new TextField(15);

    private Button save = new Button("Save");
    private Button exit = new Button(" Exit ");

    private Label messageLabel = new Label("");
    private List list = new List(5);

    public Window2(String title) {
        super(title);
        setLayout(new FlowLayout());

        add(nameLabel);
        add(textName);
        add(sumLabel);
        add(sumText);
        add(accountNrLabel);
        add(accountNrText);
        add(save);
        add(exit);
        add(messageLabel);
        add(list);

        save.addActionListener(this);
        exit.addActionListener(this);

        messageLabel.setForeground(Color.RED);
    }

    public void actionPerformed(ActionEvent e) {
        BankAccount2 bankAccount;
        double sumValue;
        int accountNr;

        if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == save) {
            if (textName.getText().equals("")) {
                messageLabel.setText("Fill Name");
                return;
            }

            if (sumText.getText().equals("")) {
                messageLabel.setText("Fill Sum");
                return;
            }
            
            if (accountNrText.getText().equals("")) {
                messageLabel.setText("Fill Account Nr");
                return;
            }

            try {
                sumValue = Double.parseDouble(sumText.getText());
                accountNr = Integer.parseInt(accountNrText.getText());
            }
            catch (NumberFormatException ex) {
                messageLabel.setText("Wrong sum");
                return;
            }

            messageLabel.setText("");

            bankAccount = new BankAccount2(textName.getText(), sumValue, accountNr);
            list.add(bankAccount.toString());

            textName.setText(null);
            sumText.setText(null);
            accountNrText.setText(null);
        }
    }


    public static void main(String[] args) {
        Window2 window2 = new Window2("Window 2"); 

        window2.pack();
        window2.setBounds(300, 250, 270, 350);
        window2.setVisible(true);
    }
}
