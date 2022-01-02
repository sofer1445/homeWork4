import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class RealEstate {
    Scanner scanner = new Scanner(System.in);

    private User[] users;
    private Property[] property;
    private Address[] address;

    public RealEstate() {
        this.users = new User[0];
        this.address = new Address[10];
        this.property = new Property[0];
    }

    public void createUser() {
        boolean typeUser;
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
        if (type == 1) {
            typeUser = true;
        } else {
            typeUser = false;
        }
        typeUser = realtorOrRegular(typeUser);
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

    private boolean realtorOrRegular(boolean type) {
        if (type) {
            return true;
        }
        return false;
    }

    public User userLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a username");
        String userName = scanner.nextLine();
        System.out.println("Type a password");
        String password = scanner.nextLine();
        User user = checkInArrayUser(userName, password);
        if (user != null) {
            return user;
        }
        return null;
    }

    private User checkInArrayUser(String userName, String password) {
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
        Scanner scanner = new Scanner(System.in);
        boolean mayPublish = false;
        String[] cityName = new String[10];
        String counter = "null";
        int numberOfAssets;
        for (int i = 0; i < users.length; i++) {
            boolean type = users[i].getTypeUser();
            mayPublish = realtorOrRegular(type);
        }
        if (mayPublish) {
            numberOfAssets = 10;
        } else {
            numberOfAssets = 3;
        }
        if (numberOfAssets > 0) {
            numberOfAssets--;
            address();
            System.out.println("Here is the list of cities available");
            for (int i = 0; i < cityName.length; i++) {
                cityName[i] = address[i].getCityName();

            }
            for (int j = 0; j < address.length; j++) {
                if (!Objects.equals(counter, cityName[j])) {
                    counter = cityName[j];
                    System.out.println(cityName[j]);

                }
            }

            System.out.println("type a city name");
            String cityNameTwo = scanner.nextLine();
            cityNameTwo = cityNameTwo.toLowerCase(Locale.ROOT);
            if (!cityNameTwo.equals("ashkelon") && !cityNameTwo.equals("tel aviv") && !cityNameTwo.equals("beer sheva")) {
                System.out.println("The typed city is incorrect");
                return false;
            }
            System.out.println("Here is a list of the streets available in the city");
            listAddress(cityNameTwo);
            System.out.println("Choose a street name");
            String streetName = scanner.nextLine();
            streetName = streetName.toLowerCase(Locale.ROOT);
            for (int i = 0; i < address.length; i++) {
                if (address[i].getStreetName().equals(streetName)) {
                    if (!Objects.equals(address[i].getCityName(), cityNameTwo)) {
                        System.out.println("The street name does not exist in this city");
                        return false;
                    }
                }
            }
            boolean answerOfAdvertisingSuccess = propertyType(user);
//התוכנית חוזרת להתחלה , צריך לשנות את זה שיחזור לתפריט 1-6

            return true;
        }
        System.out.println("You have reached the limit of property advertising");
        return false;
    }

    //public final int ggg  =12;//דוגמא לפינל
    public void address() {
        Address[] addresses = new Address[this.address.length];
        address[0] = new Address("beer sheva", "ben gurion");
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

    public void listAddress(String address) {
        if (address.equals("ashkelon")) {
            System.out.println("""
                    tabeln
                    narkis
                    ali cohen
                    """);
        }
        if (address.equals("beer sheva")) {
            System.out.println("""
                    ben gorion
                    dror
                    kasesh
                    """);
        }
        if (address.equals("tel aviv")) {
            System.out.println("""
                    ben gorion
                    hagana
                    bograshov
                    """);
        }
    }

    public boolean propertyType(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                    What is the type of property
                    1 - for a standard apartment in an apartment building,
                    2 - for a penthouse apartment in an apartment building,
                    3 - For a private home.
                    Select options 1 to 3""");
        int typeOfProperty = scanner.nextInt();
        boolean forSale = false;
        System.out.println("What floor property?\n" +
                "(If private house enter the digit 0)");
        int floorProperty = scanner.nextInt();
        System.out.println("How many rooms are there in the property");
        int manyRooms = scanner.nextInt();
        System.out.println("house number?");
        int houseNumber = scanner.nextInt();
        System.out.println("""
                Is the property for sale or rent?
                For sale press 1
                For rent press 2""");
        int theChoice = scanner.nextInt();
        if (theChoice == 1) {
            forSale = true;
        }
        System.out.println("What is the property value?");
        float price = scanner.nextInt();
        addPropertyToArray(user,typeOfProperty,floorProperty, manyRooms, houseNumber, forSale, price);
        return true;


    }


    private void addPropertyToArray(User user,int typeOfProperty,int floorProperty, int manyRooms, int houseNumber, boolean forSale, float price) {
        Property[] newArrayOfProperty = new Property[this.property.length + 1];
        for (int i = 0; i < this.property.length ; i++) {
            newArrayOfProperty[i] = this.property[i];
        }
        Property propertyToAdd = new Property(user,typeOfProperty,manyRooms,price,forSale,houseNumber,floorProperty);
        newArrayOfProperty[this.property.length] = propertyToAdd;
        this.property = newArrayOfProperty;


    }

    public void removeProperty(User user){

        for (int i = 0; i < property.length; i++) {
            User currentUser = property[i].getUser();
            if(currentUser != user && i == property.length-1){
               System.out.println("To user there is no property in the system");
               break;
            }
            if(currentUser == user){
                System.out.println("Your property by order: " + (i + 1) );
                System.out.print(property[i].toString());
            }
        }
    }
}


