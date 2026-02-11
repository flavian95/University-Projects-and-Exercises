

import java.util.Scanner;
import java.util.Formatter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends Frame implements ActionListener{
	
	private Button add = new Button("Add");
	private Button modify = new Button("Modify");
	private Button delete = new Button("Delete");
    private Button exit = new Button("Exit");

    private Label tvListLabel = new Label("");
    private List tvList = new List(10);
    
    private Label refrigeratorListLabel = new Label("");
    private List regrigeratorList = new List(10);
    
    private Panel subclassPanel = new Panel();
    private Button addTv = new Button("Add TV");
	private Button addRefrigerator = new Button("Add Refrigerator");
    
    public Window(String title) {
		super(title);
		setLayout(new FlowLayout());
//		setLayout(new GridLayout(2, 2));
		
        add(tvListLabel);
        add(tvList);
        
        add(refrigeratorListLabel);
        add(regrigeratorList);
        
        add(add);
        add(modify);
        add(delete);
        add(exit);
        
        subclassPanel.add(addTv);
        subclassPanel.add(addRefrigerator);
        
        add.addActionListener(this);
        modify.addActionListener(this);
        delete.addActionListener(this);
        exit.addActionListener(this);
	}

	private static TV[] TvCollection = new TV[50];
	private static Refrigerator[] RefrigeratorCollection = new Refrigerator[50];
	
    private static int tvCounter;
    private static int refrigeratorCounter;
    
    private static void loadTvFile() {
        Scanner tvFile= null;
        String tvFilePath;
        String[] tvData;

        try {
        	tvFile = new Scanner(new File("TV.txt"));
        }
        catch (Exception e) {
            System.err.println("Error opening files");
            System.exit(1);
        }

        while(tvFile.hasNext()){
        	tvFilePath = tvFile.nextLine();
            tvData = tvFilePath.split(" ");
            TvCollection[tvCounter++] = new TV(tvData[0] , Integer.parseInt(tvData[1]), Integer.parseInt(tvData[2]) , tvData[3]);
        }

        tvFile.close();
    }
    
    private static void loadRefigeratorFile() {
        Scanner refrigeratorFile = null;
        
        String refrigeratorPath;
        String[] refrigeratorData;

        try {
        	refrigeratorFile = new Scanner(new File("Refrigerator.txt"));
        }
        catch (Exception e) {
            System.err.println("Error opening files");
            System.exit(1);
        }

        while(refrigeratorFile.hasNext()){
        	refrigeratorPath = refrigeratorFile.nextLine();
        	refrigeratorData = refrigeratorPath.split(" ");
        	RefrigeratorCollection[refrigeratorCounter++] = new Refrigerator(refrigeratorData[0] , Integer.parseInt(refrigeratorData[1]), Integer.parseInt(refrigeratorData[2]) , refrigeratorData[3]);
        }

        refrigeratorFile.close();
    }
    
    public void displayInList() {
        for (int i = 0; i < tvCounter; i++) {
        	tvList.add(TvCollection[i].toString());
        }
        
        for (int i = 0; i < refrigeratorCounter; i++) {
        	regrigeratorList.add(RefrigeratorCollection[i].toString());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }
        
        if(e.getSource() == add) {
        	add(subclassPanel);
            pack();
        }
    }
}

//    public static void main(String[] args) {
//    	loadTvFile();
//    	loadRefigeratorFile();
//
//        Main main = new Main("Program");
//        
//        main.displayInList();
//        main.pack();
//        main.setBounds(350, 250, 470, 350);
//        main.setVisible(true);
//    }
}








































//private static TV[] TvCollection = new TV[50];
//private static Refrigerator[] RefrigeratorCollection = new Refrigerator[50];
//
//private static int tvCounter;
//private static int refrigeratorCounter;
//
//private static void loadTvFile() {
//    Scanner TvFile= null;
//    String filePath;
//    String[] TvData;
//
//    try {
//    	TvFile = new Scanner(new File("TV.txt"));
//    }
//    catch (Exception e) {
//        System.err.println("Error opening file");
//        System.exit(1);
//    }
//
//    while(TvFile.hasNext()){
//        filePath = TvFile.nextLine();
//        TvData = filePath.split(" ");
//        TvCollection[tvCounter++] = new TV(TvData[0] , Integer.parseInt(TvData[1]), Integer.parseInt(TvData[2]) , TvData[3]);
//    }
//
//    TvFile.close();
//}
//
//public void displayInList() {
//    for (int i = 0; i < tvCounter; i++) {
//    	tvList.add(TvCollection[i].toString());
//    }
//}
//
//public void actionPerformed(ActionEvent e) {
//    if (e.getSource() == exit) {
//        System.exit(0);
//    }
//}
//
//public static void main(String[] args) {
//	loadTvFile();
//
//    Main Tv1 = new Main("TV1");
//    
//    Tv1.displayInList();
//    Tv1.pack();
//    Tv1.setBounds(300, 250, 270, 350);
//    Tv1.setVisible(true);
//}
//}














//private static void saveFile(){
//    Formatter file;
//
//    try {
//        file = new Formatter ("Persons.txt");
//        for (int i=0; i<counter; i++){
//            file.format( "%s\r\n", TvCollection[i]);
//        }
//        file.close();
//    }
//
//    catch ( Exception e) {
//        System.err.println("Error creating file");
//        System.exit(1);
//    }
//}


//public static void addPerson(){
//    String name, income;
//
//    name=JOptionPane.showInputDialog("Enter name");
//    income=JOptionPane.showInputDialog("Enter income");
//
//    TvCollection[counter++]= new TV(name,Double.parseDouble(income));
//}




//public static void displayPersons(){
//for (int i=0; i<counter; i++)
//  System.out.println(TvCollection[i]);
//}