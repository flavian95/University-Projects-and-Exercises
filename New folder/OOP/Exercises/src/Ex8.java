
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

class Ex8 extends Frame implements ActionListener {
   private MenuBar menuBar = new MenuBar();
   
   private Menu option1 = new Menu("Option 1");
   private Menu option2 = new Menu("Option 2");
   private Menu option3 = new Menu("Option 3");

   private MenuItem option11 = new MenuItem("Option 1.1");
   private MenuItem option12 = new MenuItem("Option 1.2");
   private Menu option13 = new Menu("Option 1.3");
   private MenuItem exitItem = new MenuItem("Exit");
   
   private MenuItem option131 = new MenuItem("Option 1.3.1");   
   private MenuItem option132 = new MenuItem("Option 1.3.2"); 
   private MenuItem option133 = new MenuItem("Option 1.3.3"); 

   private MenuItem option21 = new MenuItem("Option 2.1");
   private MenuItem option22 = new MenuItem("Option 2.2");

   private MenuItem option31 = new MenuItem("Option 3.1");   
   private MenuItem option32 = new MenuItem("Option 3.2");   

   private TextField messageTextField = new TextField(20);
      
   public Ex8(String title) {
      super(title);
      setLayout(new BorderLayout());
         
      menuBar.add(option1);
      menuBar.add(option2);
      menuBar.add(option3);

      option1.add(option11);
      option1.add(option12);
      option1.add(option13);
      option1.addSeparator();
      option1.add(exitItem);

      option2.add(option21);
      option2.add(option22);
          
      option3.add(option31);
      option3.add(option32);
         
      option13.add(option131);	
      option13.add(option132);
      option13.add(option133);
         
      setMenuBar(menuBar);
         
      add(messageTextField, BorderLayout.SOUTH);
         
      option11.addActionListener(this);
      option12.addActionListener(this);
      option131.addActionListener(this);
      option132.addActionListener(this);
      option133.addActionListener(this);
      option21.addActionListener(this);
      option31.addActionListener(this);
      exitItem.addActionListener(this);
   }

   public void actionPerformed(ActionEvent e) {
      String command = e.getActionCommand();
      
      if (command.equals("Exit"))
         System.exit(0);
      messageTextField.setText(command + " selected");
   }
}

