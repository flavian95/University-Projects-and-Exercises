
import java.awt .*;
import java.awt.event.*;

class MyWindow extends Frame implements ActionListener {
   Button ok = new Button("OK");
   Button exit = new Button("Exit");
   int n=0;
   
   public MyWindow( String title ) {
      super( title );
      setLayout(new FlowLayout());
      setSize(200 , 100) ;
      add(ok);
      add( exit );
      ok.addActionListener( this );  	
      exit.addActionListener( this );
   }

   public void actionPerformed( ActionEvent e) { 
	      if (e.getSource() == exit )
	         System.exit(0);
	      if (e.getSource() == ok) {
	         n ++;
	         this.setTitle("You clicked OK button " + n + " times");
	      }
	   }

    public static void main(String[] args) {
      MyWindow f = new MyWindow(" Test Event ");
      f.setVisible(true);
    }
 }