import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private String field;
    private int idBook;
    
    public Book(String title, String author, String field, int idBook) {
        this.title = title;
        this.author = author;
        this.field = field;
        this.idBook = idBook;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getField() {
        return field;
    }
    
    public void setField(String field) {
        this.field = field;
    }
    
    public int getIdBook() {
        return idBook;
    }
    
    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }
    
    public static void main(String[] args) {
    	 Scanner scanner = new Scanner(System.in);
         
         System.out.print("Enter the title of the book: ");
         String title = scanner.nextLine();
         
         System.out.print("Enter the author of the book: ");
         String author = scanner.nextLine();
         
         System.out.print("Enter the field of the book: ");
         String field = scanner.nextLine();
         
         System.out.print("Enter the id of the book: ");
         int idBook = Integer.parseInt(scanner.nextLine());
         
         Book book1 = new Book(title, author, field, idBook);
         
         System.out.println("Book details:");
         System.out.println("Title: " + book1.getTitle());
         System.out.println("Author: " + book1.getAuthor());
         System.out.println("Field: " + book1.getField());
         System.out.println("Id: " + book1.getIdBook());
         
         scanner.close();
    }
}

