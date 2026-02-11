
import java.awt .*;
import java.awt.event.*;
import java.awt.event.ActionListener;

class Ex6 extends Frame implements ActionListener {
   
   private Label lName = new Label("Name");
   private TextField txtName = new TextField(20);
   
   private Label lSalary = new Label("Salary");
   private TextField txtSalary = new TextField(20);
   
   private Button save = new Button("Save");
   private Button exit = new Button("Exit");

   public Ex6( String title ) {
	      super(title);
	      setLayout(new GridLayout(3,2,10,10));
	      
	      add(lName);
	      add(txtName);
	      add(lSalary);
	      add(txtSalary);
	      add(save);
	      add(exit);
	           
	      exit.addActionListener(this);
	   }

	   public void actionPerformed( ActionEvent e) { 
	      if (e.getSource() == exit ) System.exit(0);
	   }   
	

public static void main(String[] args) {
	Ex6 gridView = new Ex6("Employee Viewer");
    
    gridView.setBounds(300, 200, 270, 150);
    gridView.setVisible(true);
}
}
