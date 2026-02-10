
import java.sql.*;
public class Conectare {//aplicam m.p. Singleton
    private static Conectare instanta;//=null
    private Connection c;
    private Statement stmt;

    private Conectare(){

        try{
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/angajatibd", "root", "");
            stmt=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);//modificam datele unei db

        }catch(SQLException e){System.out.println("exceptie din conexiune"+e.getMessage());}
    }

    public Statement getStatement(){
        return stmt;
    }

    public void inchide(){
        try{
            stmt.close();
            c.close();
        }catch(SQLException e){System.out.println("exceptie din inchidere conexiune"+e.getMessage());}
    }

    public Connection getConectare() {
        return c;
    }

    public static Conectare getInstanta(){
        if(instanta==null) instanta=new Conectare();
        return instanta;
    }

}