import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class RealEstate {
    Scanner scanner = new Scanner(System.in);
    public int delCounter = 1;
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
        int numberOfPublications = 0;
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
        if (type == 1) {
            typeUser = true;
            numberOfPublications = 10;

        } else {
            typeUser = false;
            numberOfPublications = 3;
        }
        typeUser = realtorOrRegular(typeUser);
        addUserToArray(userName, password, number, typeUser, numberOfPublications);

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

    private void addUserToArray(String username, String password, String number, boolean typeUser, int numberOfPublications) {
        User[] newArray = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            newArray[i] = this.users[i];
        }
        User userToAdd = new User(username, password, number, typeUser, numberOfPublications);
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
        int numberOfAssets = 0;
        for (int i = 0; i < users.length; i++) {
            boolean type = users[i].getTypeUser();
            numberOfAssets = users[i].getNumberOfPublications();
        }
        if (numberOfAssets > 0) {
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
            Address address = new Address(cityNameTwo, streetName);
            boolean answerOfAdvertisingSuccess = propertyType(user, address);

            return true;
        }
        System.out.println("You have reached the limit of property advertising");
        return false;
    }

    public void address() {
        Address[] addresses = new Address[this.address.length];
        address[0] = new Address("beer sheva", "ben gurion");
        address[1] = new Address("beer sheva", "dror");
        address[2] = new Address("beer sheva", "golda meir");
        address[3] = new Address("beer sheva", "kadesh");
        address[4] = new Address("tel aviv", "ibn gabirol");
        address[5] = new Address("tel aviv", "haagana");
        address[6] = new Address("tel aviv", "bograshov");
        address[7] = new Address("ashkelon", "tabeln");
        address[8] = new Address("ashkelon", "narkis");
        address[9] = new Address("ashkelon", "ali cohen");
    }

    public void listAddress(String cityNameTwo) {
        for (int i = 0; i < address.length; i++) {
            do {
                if (Objects.equals(address[i].getCityName(), cityNameTwo)) {
                    System.out.println(address[i].getStreetName());
                    i++;
                }
            } while (i != address.length && cityNameTwo.equals(address[i].getCityName()));
        }
    }

    public boolean propertyType(User user, Address address) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                What is the type of property
                1 - for a standard apartment in an apartment building,
                2 - for a penthouse apartment in an apartment building,
                3 - For a private home.
                Type your options :
                standard apartment
                penthouse apartment
                private home
                """);
        String typeOfProperty = scanner.nextLine();
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
        addPropertyToArray(user, address, typeOfProperty, floorProperty, manyRooms, houseNumber, forSale, price);
        user.setNumberOfPublications(user.getNumberOfPublications() - 1);
        return true;


    }


    private void addPropertyToArray(User user, Address address, String typeOfProperty, int floorProperty, int manyRooms, int houseNumber, boolean forSale, float price) {
        Property[] newArrayOfProperty = new Property[this.property.length + 1];
        for (int i = 0; i < this.property.length; i++) {
            newArrayOfProperty[i] = this.property[i];
        }
        Property propertyToAdd = new Property(user, address, typeOfProperty, manyRooms, price, forSale, houseNumber, floorProperty);
        newArrayOfProperty[this.property.length] = propertyToAdd;
        this.property = newArrayOfProperty;


    }

    public void removeProperty(User user) {
        Scanner scanner = new Scanner(System.in);
        int locationOfTheRemovedProperty = 0;
        for (int i = 0; i < users.length; i++) {
            User userAvailable = users[i];
            int counter = 1;
            if (property.length == 0) {
                System.out.println("To user there is no property in the system.");
                break;
            }
            if (i < property.length ^ property[i] == null) {

                User currentUser = property[i].getUser();
                if (!property[i].getUser().equals(user) && i > userAvailable.getNumberOfPublications()) {//מופיע הדפסה של זה במקרה שיש שני משתמשים והראשון רוצה להסיר נכס למרות שיש לו
                    System.out.println("To user there is no property in the system");
                    break;
                }
                if (currentUser == user) {

                    for (int j = 0; j < property.length; j++) {
                        if (property[j] == null) {
                            System.out.println("Which property you want to remove?");
                            locationOfTheRemovedProperty = scanner.nextInt();
                            break;
                        }
                        System.out.println("Your property by order: " + counter);
                        counter++;
                        System.out.print(property[j].toString());
                        if (j >= property.length - 1) {
                            System.out.println("Which property you want to remove?");
                            locationOfTheRemovedProperty = scanner.nextInt();
                            Property[] newArrayProperty = removePropertyFromArray(property[locationOfTheRemovedProperty - 1]);
                            for (int k = 0; k < newArrayProperty.length; k++) {
                                System.out.print(newArrayProperty[k].toString());
                            }
                        }
                    }
                    break;
                }
            }

        }
        property[locationOfTheRemovedProperty] = null;
        System.out.println("property deleted");

    }

    public Property[] removePropertyFromArray(Property index) {
        Property[] newProperty = new Property[property.length - 1];
        int counter = 0;
        for (int i = 0; i < property.length; i++) {
            if (property[i] != index) {
                newProperty[counter] = property[i];
                counter++;
            }
        }
        return newProperty;


    }

    public void printAllProperties() {
        System.out.println("Here is a list of all the assets in the system");
        for (int i = 0; i < property.length; i++) {
           System.out.println(property[i].toString());
        }
    }

    public void printAllPropertiesByUser(User user) {
        System.out.println("Here is the list of property of an account:" + user.getUsername());
        for (int i = 0; i < property.length; i++) {
          if(property[i].getUser().equals(user)) {
              System.out.println(property[i].toString());
          }
        }
    }

    public Property[] search() {
        Scanner scanner = new Scanner(System.in);
        boolean isSale = false;
        System.out.println("To search for a property, please answer the following questions. If the question is irrelevant please press -999");
        System.out.println("Is the property for rent or for sale?");
        String isSaleOrRent = scanner.nextLine();
        if(Objects.equals(isSaleOrRent, "sale")){
            isSale = true;
        }
        System.out.println("""
                What is the type of property you want?
                Type your options :
                                standard apartment
                                penthouse apartment
                                private home""");
        String type = scanner.nextLine();
        System.out.println("What is the desired number of rooms?");
        int numberOfRooms = scanner.nextInt();
        System.out.println("What is the minimum price range?");
        int minimum = scanner.nextInt();
        System.out.println("What is the maximum price range?");
        int maximum = scanner.nextInt();
        int forProperty = 0;
        Property[] searchProperty = new Property[0];
//        searchProperty = property;
//        for (int i = 0; i < property.length; i++) {
//            if(property[i].isForSale() == isSale){
//                searchProperty[i] = property[i];
//            }
//
//        }
        for (int j = 0; j < property.length; j++) {
            if ((property[j].isForSale() == isSale) && (property[j].getTypeProperty()).equals(type) || Objects.equals(type, -999) &&
                    (property[j].getNumberRooms() == numberOfRooms || (numberOfRooms == -999)) &&
                    (property[j].getPrice() > minimum || (minimum == -999) && property[j].getPrice() < maximum || (minimum == -999))) {
                forProperty++;
                searchProperty = new Property[forProperty];
                for (int i = 0; i < searchProperty.length; i++) {
                    searchProperty[j] = property[j];
                    System.out.println(searchProperty[j]);
                }
            }
        }
        return searchProperty;
    }


}




