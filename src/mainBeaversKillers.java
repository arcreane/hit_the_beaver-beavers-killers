
public class mainBeaversKillers {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome !");
        // Listen to user answer
        String menu = """
                You can choose between these options :
                ***** Play             --> type P
                ***** View High Scores --> type H
                ***** Quit game        --> type Q""";
        String choice = getPlayerEntry.get_usr_choice(menu, "P", "H", "Q");
        while (!choice.equals("Q")) {
            switch (choice) {
                case "P" -> boardSetting.createBoard();
                case "H" -> HighScore.toto();
            }
            choice = getPlayerEntry.get_usr_choice(menu, "P", "H", "Q");
        }
        System.out.println("Bye bye! See ya!!");
    }
}
