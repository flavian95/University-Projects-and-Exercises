
import java.util.Scanner;
import java.util.Formatter;
import java.io.File;
import java.io.IOException;
import javax.swing.*; 

public class Ex2{
    private static ThePerson2[] collection = new ThePerson2[50];
    private static int counter;
     
    private static void loadFile(){
        Scanner file= null;
        String filePath;
        String[] personData;
        
        try {
            file = new Scanner(new File("Persons.txt")); 
        }
        catch (Exception e) {
            System.err.println("Error opening file"); 
            System.exit(1); 
        }
        
        while(file.hasNext()){
            filePath = file.nextLine();
            personData = filePath.split(" ");
            collection[counter++] = new ThePerson2(personData[0] + " " + personData[1], Double.parseDouble(personData[2]));        
        }
        
        file.close();       
}
    

    private static void saveFile(){
        Formatter file;
        
        try {
        	file = new Formatter ("Persons.txt");
                 for (int i=0; i<counter; i++){
                       file.format( "%s\r\n", collection[i]);
              }
            file.close();   
        }
        
        catch ( Exception e) {
             System.err.println("Error creating file");
             System.exit(1); 	
        }
     }
    
     public static void displayPersons(){
         for (int i=0; i<counter; i++)
             System.out.println(collection[i]);
     } 
     
     public static void addPerson(){
          String name, income;
          
          name=JOptionPane.showInputDialog("Enter name");
          income=JOptionPane.showInputDialog("Enter income");
          
          collection[counter++]= new ThePerson2(name,Double.parseDouble(income));
     }

     public static void main(String[] args){
         System.out.println("Loading file");          
         loadFile();
         displayPersons(); 
         addPerson();
         addPerson();
         saveFile();
   }   
}