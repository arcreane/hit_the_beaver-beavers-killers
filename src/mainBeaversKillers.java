import java.util.Scanner;

public class mainBeaversKillers {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome !");
        // Listen to user answer
        String menu = """
                You can choose between these options :
                ***** Exercise 1 --> type P
                ***** Exercise 2 --> type H
                ***** Quit app   --> type Q""";
        String choice = getPlayerEntry.get_usr_choice(menu, "P", "H", "Q");
        while (!choice.equals("Q")) {
            switch (choice) {
                case "P" -> System.out.println("Let's play!");
                case "H" -> HighScore.toto();
            }
            choice = getPlayerEntry.get_usr_choice(menu, "P", "H", "Q");
        }
        System.out.println("Bye bye! See ya!!");
    }
}
