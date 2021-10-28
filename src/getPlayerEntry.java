import java.util.Arrays;
import java.util.Scanner;


public class getPlayerEntry {
    static int[] getcoordEntry(int height) {
        /*
        Return a valid Player entry for game loop, whatever the entry is.
         */
        int[] entry = new int[2];
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);
        outter:
        do {
            System.out.println("Where is the beaver, enter number coordinates as : line column.\nExample : 0 1");
            for (int i = 0; i < 2; i++) {
                int number;
                try {
                    number = scanner.nextInt();
                }catch(Exception e) {
                    System.out.println("No valid entry!");
                    scanner.nextLine();
                    continue outter;
                }
                entry[i] = number;
                }
            if(entry[0]<height && entry[1]<height)
                valid = true;
            }while (!valid);
            scanner.nextLine();
            System.out.println(Arrays.toString(entry));
            return entry;
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
