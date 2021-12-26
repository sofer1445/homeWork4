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
        while (!checkAvailability) {
            System.out.println("Existing system user Try again");
            userName = scanner.nextLine();
            checkAvailability = userAvailability(userName);
        }
        System.out.println("type a password ");
        String password = scanner.nextLine();
        boolean PasswordStrengthCheck = passwordCheck(password);
        while (!PasswordStrengthCheck) {
            System.out.println("Weak password try again");
            password = scanner.nextLine();
            PasswordStrengthCheck = passwordCheck(password);

        }
        System.out.println("Enter your phone number: ");
        String number = scanner.nextLine();
        boolean phoneNumber = phoneNumberCheck(number);
        while (!phoneNumber) {
            System.out.println("Wrong phone number, please try again");
            number = scanner.nextLine();
            phoneNumber = phoneNumberCheck(number);
        }
        System.out.println("""
                Are you realtor or a regular user?\s
                for realtor press 1\s
                for regular user press 2\s""");
        int type = scanner.nextInt();
        boolean typeUser = realtorOrRegular(type);
        addUserToArray(userName, password, number, typeUser);
        mainMenu();
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

    private void addUserToArray(String username, String password, String number, boolean typeUser) {
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
                if (password.charAt(j) <= '9') {
                    counterNumber++;
                }
                if (counterNumber >= 1 && counterTav >= 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean phoneNumberCheck(String number) {

        if (number.length() == 10) {
            if (number.charAt(0) == '0' && number.charAt(1) == '5') {
                for (int i = 2; i <= number.length(); i++) {
                    if (number.charAt(i) >= '0' && number.charAt(i) <= '9') {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean realtorOrRegular(int type) {
        if (type == 1) {
            return true;
        }
        return false;
    }

    private void mainMenu(){
        System.out.println("""
                Hello User, Please select one of the following options:
                1 - Create an account
                2 - Log in to an existing account
                3 - Finish the program""");
        Scanner scanner = new Scanner(System.in);
        int options = scanner.nextInt();
        if(options==1){
            createUser();
        }
        if(options==2){
            userLogin();
        }
        if(options==3){
            //Finish the program
        }
    }
    public User userLogin(){
        Scanner scanner = new Scanner(System.in);
        int theChoice;
        System.out.println("Please enter a username");
        String userName = scanner.nextLine();
        System.out.println("Type a password");
        String password = scanner.nextLine();
        User checkExists = checkInArrayUser(userName);
        if(checkExists != null){
            System.out.println("""
                    1 - Post a new property
                    2 - Remove advertising on a property
                    3 - View all assets in the system
                    4 - View all assets posted by the user
                    5 - Search for property by parameters
                    6 - Disconnect and return to the main menu""");
            theChoice = scanner.nextInt();
        } else {
            System.out.println("User does not exist");
            mainMenu();
            return null;
        }
            return null;
    }
    private User checkInArrayUser(String user){
        for (int i = 0; i < users.length; i++) {
            if(users[i].equals(user)){//כל בזמן יוצא false בגלל שבוא בדוק לפי כתובת ולא מציג אותו בתוך המערך כstring  
                return users[i];
            }
            }return null;


        }
    }



