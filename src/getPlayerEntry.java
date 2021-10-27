import java.util.Scanner;

public class getPlayerEntry {
    static String PlayerEntry(){
        String entry = "";
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
}
