public class User {

    private String userName;
    private String password;
    private String number;
    private int typeUser;

    public User(String username, String password , int typeUser) {
        this.userName = username;
        this.password = password;
        this.typeUser = typeUser;
    }

    public void setUserName(String userName) {
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

    public int getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
    }
}
