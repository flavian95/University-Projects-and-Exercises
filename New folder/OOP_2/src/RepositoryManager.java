
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RepositoryManager {
    private static RepositoryManager instance;
    private Statement stmt;
    private Connection connection;

    private RepositoryManager() {
        Conectare c = Conectare.getInstanta();
        connection = c.getConectare();
    }

    public static RepositoryManager getInstance() {
        if(instance == null) {
            instance = new RepositoryManager();
        }
        return instance;
    }

    public boolean CreateAccount(Account account) {
        try {
            var ps = connection.prepareStatement("insert into conturi (username, parola) values (?, ?)");
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.executeUpdate();

            return true;
        }catch(SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean modificaParola(Account account, String newParola){
        try {
            var ps = connection.prepareStatement("update conturi set parola=? where username=? and parola=?");
            ps.setString(1, newParola);
            ps.setString(2, account.getUsername());
            ps.setString(3, account.getPassword());
            ps.executeUpdate();

            return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean stergeCont(Account account) {
        try {
            var ps = connection.prepareStatement("delete from conturi where username=? and parola=?");
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getPassword());
            ps.executeUpdate();

            return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public Account cautaCont(String username, String password) {
        try {
            var ps = connection.prepareStatement("select * from conturi where username=? and parola=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if(rs.next() == true) {
                Account acc = new Account(rs.getString(2), rs.getString(3));
                return acc;
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public ArrayList<Account> getConturi() {
        ArrayList<Account> listaConturi = new ArrayList<>();
        try {
            var ps = connection.prepareStatement("select * from conturi");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                listaConturi.add(new Account(rs.getString(2), rs.getString(3)));
            }

        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return listaConturi;
    }
}
