import java.util.Scanner;

public class mainBeaversKillers {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome !");
        // Listen to user answer
        String choice = get_user_choice();
        while (!choice.equals("Q")) {
            switch (choice) {
                case "J" -> System.out.println("Exercise 1");
                case "H" -> System.out.println("Exercise 2");
                case "Q" -> System.out.println("Bye bye! See ya!!");
            }
            choice = get_user_choice();
        }

    }

    static String get_user_choice(){
        /*
        Displays possibles choices and make sure that it is a valid choice.
         */
        Scanner scanner = new Scanner(System.in);
        String choice;
        do{
            System.out.println("""
                You can choose between these options :
                ***** Exercise 1 --> type J
                ***** Exercise 2 --> type H
                ***** Quit app   --> type Q""");
            System.out.println("Choose which exercise you want to do :");
            choice = scanner.nextLine();
            if (!(choice.equals("J") || choice.equals("H") || choice.equals("Q")))
                System.out.println("Please enter a valid choice.\n");
        }
        while (!(choice.equals("J") || choice.equals("H") || choice.equals("Q")));
        return choice;
    }
}