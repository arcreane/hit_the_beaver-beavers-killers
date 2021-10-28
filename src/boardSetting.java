import java.util.stream.Collectors;
import java.util.stream.Stream;

public class boardSetting {
    public static String[][] createBoard() {
        System.out.println("Select level");
        int height = 0;
        int timer = 0;
        String menu = """
                1 : Easy
                2 : Medium
                3 : Hard
                """;
        String level = getPlayerEntry.get_usr_choice(menu, "1", "2", "3");
        switch (level) {
            case "1":
                height = 5;
                timer = 4000;
                break;
            case "2":
                height = 7;
                timer = 3500;
                break;
            case "3":
                height = 10;
                timer = 3000;
        }

        String[][] board = new String[height][height];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "●︎";
            }
        }
        return board;
    }

    public static void displayBoard(String[][] board ) {
        StringBuilder build = new StringBuilder();
        build.append("  ");
        for (int i = 0; i < board.length ; i++) {
            build.append(i + "   ");
        }
        build.append("\n");
        for (int i = 0; i < board.length ; i++) {

            build.append("_____");
        }
        build.append("\n");
        for (int i = 0; i < board.length; i++) {
            build.append(Stream.of(board[i])
                    .collect(Collectors.joining("   ", (i) + "⎟", "  -")));
            build.append("\n");
        }
        System.out.println((build.toString()));
    }

}






