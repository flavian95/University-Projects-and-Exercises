
public class Account {
    private String password;
    private String username;

    public Account( String username, String password) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Account{" +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}