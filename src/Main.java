import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RealEstate realEstate = new RealEstate();
        int userSelection1;
        int userSelection2;
        do {
            do {
                System.out.println("""
                        Hello User, Please select one of the following options:
                        1 - Create an account
                        2 - Log in to an existing account
                        3 - Finish the program""");
                userSelection1 = scanner.nextInt();
            } while (userSelection1 > 3 || userSelection1 <= 0);

            if (userSelection1 == 1) {
                realEstate.createUser();
            }
            if (userSelection1 == 2) {
                User logain = realEstate.userLogin();
                if (logain == null) {
                    System.out.println("User does not exist or one of the parameters is incorrect");
                } else {
                    do {
                        userSelection2 = internalMenu();
                        switch (userSelection2) {
                            case 1: //לשנות לשמות משמעותים
                                realEstate.postNewProperty(logain);
                                break;
                            case 2:
                                realEstate.removeProperty(logain);
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                        }
                    } while (userSelection2 != 6 );
                }

            }
        } while (userSelection1 != 3);


    }

    public static int internalMenu() {
        Scanner scanner = new Scanner(System.in);
        int userSelection;
            System.out.println("""
                    1 - Post a new property
                    2 - Remove advertising on a property
                    3 - View all assets in the system
                    4 - View all assets posted by the user
                    5 - Search for property by parameters
                    6 - Disconnect and return to the main menu""");
            userSelection = scanner.nextInt();

        return userSelection;

    }
}


