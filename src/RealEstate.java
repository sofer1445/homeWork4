import java.util.Locale;
import java.util.Scanner;

public class RealEstate {
    Scanner scanner = new Scanner(System.in);

    private User[] users;
    private String property;
    private Address[] address;

    public RealEstate() {
        this.users = new User[0];
        this.address = new Address[10];
    }

    public void createUser() {
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
        User userToAdd = new User(username, password, number , typeUser);
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

    public User userLogin() {
        System.out.println("Please enter a username");
        String userName = scanner.next();
        System.out.println("Type a password");
        String password = scanner.next();
        User user = checkInArrayUser(userName , password);
        if (user != null) {
            return user;
        }
        return null;
    }

    private User checkInArrayUser(String userName ,String password) {
        for (int i = 0; i < users.length; i++) {
            User user = this.users[i];
            if (user.getUsername().equals(userName)) {
                if (user.getPassword().equals(password)) {
                    return users[i];
                }
            }
        }
        return null;


    }

   public boolean postNewProperty(User user) {
        int numberOfAssets = realtorOrRegular() ; // לטפל בזה צריך לקבל כאן את הסוג משתמש
        if (numberOfAssets > 0) {
            numberOfAssets--;
            System.out.println("""
                    Ashkelon
                    Beer Sheva
                    Tel Aviv""");
            System.out.println("type a city name");
            String cityName = scanner.nextLine();
            cityName.toLowerCase(Locale.ROOT);
            listAddress(cityName);
            if(!cityName.equals("ashkelon") && !cityName.equals("beer sheva") && !cityName.equals("tel aviv")){
                System.out.println("The typed city is incorrect");
                return false;
            }
            System.out.println("Choose a street name");
            String streetName = scanner.nextLine();
            streetName.toLowerCase(Locale.ROOT);
            for (int i = 0; i < address.length; i++) {
                if(address[i].getStreetName().equals(streetName)){
                }
            }
        return true;
    }
        System.out.println("You have reached the limit of property advertising");
        return false;
}


    public void address() {
        Address[] addresses = new Address[this.address.length];
        address[0] = new Address("beer sheva,", "ben gurion");
        address[1] = new Address("beer sheva", "dror");
        address[2] = new Address("beer sheva", "golda meir");
        address[3] = new Address("beer sheva", "kadesh");
        address[4] = new Address("tel aviv", "ben gurion");
        address[5] = new Address("tel aviv", "haagana");
        address[6] = new Address("tel aviv", "bograshov");
        address[7] = new Address("ashkelon", "tabeln");
        address[8] = new Address("ashkelon", "narkis");
        address[9] = new Address("ashkelon", "ali cohen");

        //לבדוק עם שי אם אפשר להדפיס כך או צריך לעשות לולאה כדי לחלץ את הערים

    }

    public void listAddress (String address){
        if(address.equals("ashkelon")){
            System.out.println("""
                        tabeln
                        narkis
                        ali cohen
                        """);
        }if(address.equals("beer sheva")){
            System.out.println("""
                        ben gorion
                        dror
                        kasesh
                        """);
        }
        if(address.equals("tal aviv")){
            System.out.println("""
                        ben gorion
                        hagana
                        bograshov
                        """);
        }
    }

}
//    User[] newArray = new User[this.users.length + 1];
//        for (int i = 0; i < this.users.length; i++) {
//        newArray[i] = this.users[i];


