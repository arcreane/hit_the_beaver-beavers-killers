import java.io.IOException;

public class mainBeaversKillers {
    public static void main(String[] args) throws IOException {
        // Welcome message
        HighScore.init_HighScores();
        System.out.println("Welcome !");
        // Listen to user answer
        String menu = """
                You can choose between these options :
                ***** Play a game     --> type P
                ***** See High Scores --> type H
                ***** Preferences     --> type O
                ***** Quit game       --> type Q""";
        String choice = "";
        while (!choice.equals("Q")) {
            switch (choice) {
                case "P" -> GamePlay.playRounds();
                case "H" -> HighScore.affiche_High_Score();
                case "O" -> getPlayerEntry.Preferences();
            }
            choice = getPlayerEntry.get_usr_choice(menu, "P", "H", "O");
        }
        System.out.println("Bye bye! See ya!!");
    }

}
