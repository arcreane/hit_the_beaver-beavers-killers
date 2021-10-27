import java.util.Scanner;

public class getPlayerEntry {
    static String getEntry(){
        String entry;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Where is the beaver, enter number coordinates as : x,y");
            entry = scanner.nextLine();
        } while (!validateEntry(entry));
        scanner.nextLine();
        return entry;
    }
    static boolean validateEntry(String p_s_entry){
        /*
        Checks if user input is entered as expected by player.
         */
        String regex = "\\d,\\d";
        return regex.matches(p_s_entry);
    }

    static String get_usr_choice(String menuList, String A, String B, String C) {
        /*
        Displays possibles choices and make sure that it is a valid choice.
         */
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println(menuList);
            System.out.println("Type your choice :");
            choice = scanner.nextLine();
            if (!(choice.equals(A) || choice.equals(B) || choice.equals(C)))
                System.out.println("Please enter a valid choice.\n");
        }
        while (!(choice.equals(A) || choice.equals(B) || choice.equals(C)));
        return choice;
    }
}
