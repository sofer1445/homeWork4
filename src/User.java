public class User {

    private String userName;
    private String password;
    private String number;
    private boolean typeUser;

    public User(String username, String password , String number, boolean typeUser) {
        this.userName = username;
        this.password = password;
        this.typeUser = typeUser;
        this.number = number;
    }

    public String setUserName(String userName) {
        this.userName = userName;
    }

    public String getUsername() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getTypeUser() {
        return this.typeUser;
    }

    public void setTypeUser(boolean typeUser) {
        this.typeUser = typeUser;
    }
}
