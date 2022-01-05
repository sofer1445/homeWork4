import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    private static final int POST_NEW_PROPERTY = 1;
    private static final int REMOVE_PROPERTY = 2;
    private static final int PRINT_ALL_PROPERTIES = 3;
    private static final int GET_PRINT_ALL_PROPERTIES_BY_USER = 4;
    private static final int SEARCH_PROPERTY = 5;
    private static final int END_PROGRAM = 6;
    private static final int USER_SELECTION2 = 6;
    private static final int FIRST_MAIN_FIRST_OPTION = 1;
    private static final int FIRST_MAIN_SECOND_OPTION = 2;
    private static final int FIRST_MAIN_THIRD_OPTION = 3;
    private static final int FIRST_MAIN_NOT_IN_OPTION = 0;

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
            } while (userSelection1 > FIRST_MAIN_THIRD_OPTION || userSelection1 <= FIRST_MAIN_NOT_IN_OPTION);

            if (userSelection1 == FIRST_MAIN_FIRST_OPTION) {
                realEstate.createUser();
            }
            if (userSelection1 == FIRST_MAIN_SECOND_OPTION) {
                User logain = realEstate.userLogin();
                if (logain == null) {
                    System.out.println("User does not exist or one of the parameters is incorrect");
                } else {
                    do {
                        userSelection2 = internalMenu();
                        switch (userSelection2) {
                            case POST_NEW_PROPERTY:
                                realEstate.postNewProperty(logain);
                                break;
                            case REMOVE_PROPERTY:
                                realEstate.removeProperty(logain);
                                break;
                            case PRINT_ALL_PROPERTIES:
                                realEstate.printAllProperties();
                                break;
                            case GET_PRINT_ALL_PROPERTIES_BY_USER:
                                realEstate.printAllPropertiesByUser(logain);
                                break;
                            case SEARCH_PROPERTY:
                                Property[] printProperties = realEstate.search();
                                for (int i = 0; i < printProperties.length; i++) {
                                    System.out.println(printProperties[i]);
                                }
                                break;
                            case END_PROGRAM:
                                break;
                        }
                    } while (userSelection2 != USER_SELECTION2);
                }

            }
        } while (userSelection1 != FIRST_MAIN_THIRD_OPTION);


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


