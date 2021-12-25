import java.util.Scanner;

public class RealEstate {

    private User[] users;
    private String property;
    private String address;

    public RealEstate() {
        this.users = new User[0];

    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a username");
        String userName = scanner.nextLine();
        boolean checkAvailability = userAvailability(userName);
        while (checkAvailability) {
            System.out.println("try again");
            userName = scanner.nextLine();
            userAvailability(userName);
        }
        System.out.println("type a password ");
        String password = scanner.nextLine();
        boolean passwordCheck = passwordCheck(password);
        while (!passwordCheck) {
            System.out.println("Weak password try again");
            password= scanner.nextLine();
            passwordCheck(password);
        }
        //מתודה של בדיקת מספר טלפון
        //לבקש סוג משתמש
    }

    public boolean userAvailability(String user) {
        boolean checkAvailability = true;
        for (int i = 0; i < this.users.length; i++) {
            User currentUser = this.users[i];
            if (currentUser.getUsername().equals(user)) {
                checkAvailability = false;
                break;
            }

        }
        return checkAvailability;
    }

    private void addUserToArray(String username, String password, int number, boolean typeUser) {
        User[] newArray = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            newArray[i] = this.users[i];
        }
        User userToAdd = new User(username, password, number, typeUser);
        newArray[this.users.length] = userToAdd;
        this.users = newArray;
    }

    private boolean passwordCheck(String password) {
        String tavInPassword = "%_$";
        int counterTav = 0;
        int counterNumber = 0;
        for (int i = 0; i < tavInPassword.length(); i++) {
            for (int j = 0; j < password.length(); j++) {
                if (password.charAt(j) == tavInPassword.charAt(i)) {
                    counterTav++;
                }
                if (password.charAt(j) <= 9) {
                    counterNumber++;
                }
                if (counterNumber >= 1 && counterTav >= 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

//    public void addAccount () {
//        Scanner scanner = new Scanner(System.in);
//        String username = null;
//        do {
//            System.out.println("Enter username: ");
//            username = scanner.nextLine();
//        } while (isUsernameExist(username));
//        String password = null;
//
//        do {
//            System.out.println("Enter password: ");
//            password = scanner.nextLine();
//        } while (!isStrongPassword(password));
//
//        addUserToArray(username, password);
//
//    }
//    private boolean isUsernameExist (String usernameToCheck) {
//        boolean exists = false;
//        for (int i = 0; i < this.users.length; i++) {
//            User currentUser = this.users[i];
//            if (currentUser.getUsername().equals(usernameToCheck)) {
//                exists = true;
//                break;
//            }
//        }
//        return exists;
//    }
//}

