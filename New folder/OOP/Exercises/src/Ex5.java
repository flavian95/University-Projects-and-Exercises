
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ex5 extends Frame implements ActionListener {
    private ThePerson2[] employees = new ThePerson2[50];
    private int numberOfEmployees;
    
    private Label nameLabel = new Label("Name");
    private TextField nameTextField = new TextField(20);

    private Label salaryLabel = new Label("Salary");
    private TextField salaryTextField = new TextField(20);

    private Button firstButton = new Button("First");
    private Button previousButton = new Button("Previous");
    private Button nextButton = new Button("Next");
    private Button lastButton = new Button("Last");
    private Button exitButton = new Button("Exit");
    private int currentIndex = 0;

    public Ex5(String title) {
        super(title);
        setLayout(new FlowLayout());
        
        add(nameLabel);
        add(nameTextField);
        add(salaryLabel);
        add(salaryTextField);
        add(firstButton);
        add(previousButton);
        add(nextButton);
        add(lastButton);
        add(exitButton);
        
        firstButton.addActionListener(this);
        previousButton.addActionListener(this);
        nextButton.addActionListener(this);
        lastButton.addActionListener(this);
        exitButton.addActionListener(this);

        employees[0] = new ThePerson2("First Name", 2000);
        employees[1] = new ThePerson2("Second Name", 2800);
        employees[2] = new ThePerson2("Third Name", 2500);
        
        numberOfEmployees = 3;
        transferCurrentEmployee();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) System.exit(0);
        if (e.getSource() == nextButton && currentIndex < numberOfEmployees - 1) {
            currentIndex++;
            transferCurrentEmployee();
        }
        if (e.getSource() == previousButton && currentIndex > 0) {
            currentIndex--;
            transferCurrentEmployee();
        }
        if (e.getSource() == firstButton && numberOfEmployees > 0) {
            currentIndex = 0;
            transferCurrentEmployee();
        }
        if (e.getSource() == lastButton && numberOfEmployees > 0) {
            currentIndex = numberOfEmployees - 1;
            transferCurrentEmployee();
        }
    }

    private void transferCurrentEmployee() {
        double currentSalary;
        
        nameTextField.setText(employees[currentIndex].getName());
        currentSalary = employees[currentIndex].getSalary();
        
        salaryTextField.setText(String.valueOf(currentSalary));
    }

    public static void main(String[] args) {
        Ex5 employeeViewer = new Ex5("Employee Viewer");
        
        employeeViewer.setBounds(300, 200, 270, 150);
        employeeViewer.setVisible(true);
    }
}