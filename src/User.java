public class User {

    private String userName;
    private String password;
    private int number;
    private boolean typeUser;

    public User (String username, String password,int number, boolean typeUser) {
        this.userName = username;
        this.password = password;
        this.number = number;
        this.typeUser = typeUser;
    }

    public String getUsername () {
        return this.userName;
    }

}
