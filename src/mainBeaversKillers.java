import java.util.Scanner;

public class mainBeaversKillers {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome !");
        // Listen to user answer
        String choice = get_user_choice();
        while (!choice.equals("Q")) {
            switch (choice) {
                case "J" -> boardSetting.createBoard();
                case "H" -> HighScore.toto();
                case "t" -> TimerModule.Timer(2000);
            }
            choice = get_user_choice();
        }
        System.out.println("Bye bye! See ya!!");

    }

    static String get_user_choice(String menu, char A, char B, char C) {
        /*
        Displays possibles choices and make sure that it is a valid choice.
         */
        Scanner scanner = new Scanner(System.in);
        String choice;
        String menuListe ="""
                    You can choose between these options :
                    ***** Exercise 1 --> type J
                    ***** Exercise 2 --> type H
                    ***** Quit app   --> type Q""";
        do {
            System.out.println(menuListe);
            System.out.println("Type your choice :");
            choice = scanner.nextLine();
            if (!(choice.equals(A) || choice.equals(B) || choice.equals(C)  || choice.equals("t")))
                System.out.println("Please enter a valid choice.\n");
        }
        while (!(choice.equals(A) || choice.equals(B) || choice.equals(C) || choice.equals("t")));
        return choice;
    }
}
