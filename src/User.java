public class User {

    private String userName;
    private String password;
    private String number;
    private boolean typeUser;
    private int numberOfPublications;

    public User(String username, String password , String number, boolean typeUser,int numberOfPublications) {
        this.userName = username;
        this.password = password;
        this.typeUser = typeUser;
        this.number = number;
        this.numberOfPublications = numberOfPublications;
    }

    public String setUserName(String userName) {
      return this.userName;
    }
    public String getNumber (){
        return this.number;
    }

    public String getUsername() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public int getNumberOfPublications() {
        return numberOfPublications;
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

    public void setNumberOfPublications(int numberOfPublications) {
        this.numberOfPublications = numberOfPublications;
    }

    public String toString () {
        return this.getUsername()+" " + this.number ;


    }
}
