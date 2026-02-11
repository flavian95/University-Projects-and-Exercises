import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.List;

class Window extends Frame implements ActionListener {

    private Label nameLabel = new Label("Name");
    private TextField textName = new TextField(20);

    private Label salaryLabel = new Label("Salary");
    private TextField salaryText = new TextField(20);

    private Button save = new Button("Save");
    private Button exit = new Button(" Exit ");

    private Label messageLabel = new Label("");
    private List list = new List(5);

    public Window(String title) {
        super(title);
        setLayout(new FlowLayout());

        add(nameLabel);
        add(textName);
        add(salaryLabel);
        add(salaryText);
        add(save);
        add(exit);
        add(messageLabel);
        add(list);

        save.addActionListener(this);
        exit.addActionListener(this);

        messageLabel.setForeground(Color.RED);
    }

    public void actionPerformed(ActionEvent e) {
        ThePerson2 firstPerson;
        double salaryValue;

        if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == save) {
            if (textName.getText().equals("")) {
                messageLabel.setText("Fill Name");
                return;
            }

            if (salaryText.getText().equals("")) {
                messageLabel.setText("Fill Salary");
                return;
            }

            try {
                salaryValue = Double.parseDouble(salaryText.getText());
            } catch (NumberFormatException ex) {
                messageLabel.setText("Wrong salary");
                return;
            }

            messageLabel.setText("");

            firstPerson = new ThePerson2(textName.getText(), salaryValue);
            list.add(firstPerson.toString());

            textName.setText(null);
            salaryText.setText(null);
        }
    }

    public static void main(String[] args) {
        Window window1 = new Window("Window 1");

        window1.pack();
        window1.setBounds(300, 200, 270, 250);
        window1.setVisible(true);
    }
}

