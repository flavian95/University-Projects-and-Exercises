package Lab2;

import java.util.*;
import java.io.*;

public class BooksCollection {
    private static BooksCollection instance;
    private ArrayList<Book> bookList;

    private BooksCollection() {
        bookList = new ArrayList<>();
        readFile();
    }

    public static BooksCollection getInstance() {
        if (instance == null)
            instance = new BooksCollection();
        return instance;
    }

    public void readFile() {
        try{
          String line, line2;
          String[] s1, s2;
          BufferedReader br = new BufferedReader(new FileReader("books.txt"));

          while(br1.ready){
            line2 = br2.readLine();
            s1=line.split("[.]");
            s2 = line2.split(" ");
            line2= (New Book(s1[0], s2[0], Double.parseDouble(s2[0], s2[1])));

            bookList.add(new Book(s[0], s[1]));
          }
          br.close;
        }
        catch(IOException e){e.printStackTrace();}
    }

    public Object[] getBooks() {
        return bookList.toArray();
    }

    public Book getBook(int position){
        if(position> 0 && position < lc.size() > 0)
    }

}
