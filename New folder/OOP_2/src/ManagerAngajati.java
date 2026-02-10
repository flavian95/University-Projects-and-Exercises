import java.sql.*;
public class ManagerAngajati {//impl ca o clasa utilitara
    private static Conectare c=Conectare.getInstanta();

    public static String getAngajati(){
        StringBuffer sb=new StringBuffer("");
        var stmt=c.getStatement();
        String comanda="Select * from datepersonale";
        try{
            ResultSet rs=stmt.executeQuery(comanda);
            while(rs.next()){
                sb.append(rs.getString(1));
                sb.append(" are adresa de mail: ");
                sb.append(rs.getString(2));
                sb.append("\n");
            }
        }catch(SQLException e){System.out.println("exceptie din select"+e.getMessage());}
        return sb.toString();
    }

    public static boolean memoreazaAngajat(String nume, String prenume, String email){
        var stmt=c.getStatement();
        var comanda="insert into datepersonale (Nume, Prenume, Email) values (\""+nume+"\", \""+prenume+"\", \""+email+"\")";
        try{
            stmt.executeUpdate(comanda);
            return true;
        }catch(SQLException e){System.out.println("exceptie din memoreaza angajat"+e.getMessage());}
        return false;
    }


    public static String cauta(String nume, String prenume){
        var stmt=c.getStatement();
        String comanda="Select * from datepersonale";
        try{
            ResultSet rs=stmt.executeQuery(comanda);
            while(rs.next()){
                if(rs.getString(2).equals(nume)&& rs.getString(3).equals(prenume)) return rs.getString(4);
            }
            return "angajatul nu exista";
        }catch(SQLException e){System.out.println("exceptie din cauta angajat"+e.getMessage());}
        return "eroare din cauta bd";
    }

    public static String cautaWhere(String nume, String prenume){
        var stmt=c.getStatement();
        String comanda="Select * from datepersonale where Nume=\""+nume+"\" and Prenume=\""+prenume+"\"";
        try{
            ResultSet rs=stmt.executeQuery(comanda);
            if(rs.next())  return rs.getString(4);
            else return "angajatul nu exista";
        }catch(SQLException e){System.out.println("exceptie din cautawhere angajat"+e.getMessage());}
        return "eroare din cautawhere bd";
    }
}
