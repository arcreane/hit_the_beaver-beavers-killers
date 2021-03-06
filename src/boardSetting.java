import java.util.stream.Collectors;
import java.util.stream.Stream;

public class boardSetting {
    static int timer = 0;
    static int height = 0;
    static String[] boardRow = new String[10];

    /**
     * Define Row and Column titles
     */
    public static void fillUp() {
        // fill up array with numbers as String
        if (getPlayerEntry.board_Mode == 1) {
            for (int i = 0; i < 10; i++) {
                boardRow[i] = Integer.toString(i);
            }
        } else { // fill up row/columns titles of array with EMOJI
            boardRow[0] = "0️⃣";
            boardRow[1] = "1️⃣";
            boardRow[2] = "2️⃣";
            boardRow[3] = "3️⃣";
            boardRow[4] = "4️⃣";
            boardRow[5] = "5️⃣";
            boardRow[6] = "6️⃣";
            boardRow[7] = "7️⃣";
            boardRow[8] = "8️⃣";
            boardRow[9] = "9️⃣";
        }
    }

    /**
     * Creates the array of the game according to chosen level
     * @return
     */
    public static String[][] createBoard() {
        System.out.println("Select level");
        height = 0;
        timer = 0;
        //create the menu of level
        String menu = """
                1 : Easy
                2 : Medium
                3 : Hard""";
        String level = getPlayerEntry.get_usr_choice(menu, "1", "2", "3");
        //return a choice of level

        //initialization of level with size of the board and timer
        switch (level) {
            case "1" -> {
                height = 5;
                if (getPlayerEntry.usr_level.equals("Rookie")) timer = 8000;
                else timer = 5000;
            }
            case "2" -> {
                height = 7;
                if (getPlayerEntry.usr_level.equals("Rookie")) timer = 7000;
                else timer = 4000;
            }
            case "3" -> {
                height = 10;
                if (getPlayerEntry.usr_level.equals("Rookie")) timer = 5000;
                else timer = 3500;
            }
        }
        //create a board
        String[][] board = new String[height][height];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = getPlayerEntry.Cell_icon;
            }
        }
        if (!level.equals("Q")) return board;
        else return null;
    }

/**
 *  create a formatted image to display the board
 */
    public static void displayBoard(String[][] board) {
        StringBuilder build = new StringBuilder();// create 'build' array to be displayed
        build.append("  ");
        //update first spacing for my emoji mode
        if (getPlayerEntry.board_Mode == 2)
            build.append(" ");
        //it's my title row
        for (int i = 0; i < board.length; i++) {
            build.append(boardRow[i] + "   ");
        }
        build.append("\n");
        // it's my title column
        for (int i = 0; i < board.length; i++) {
            build.append(Stream.of(board[i])
                    .collect(Collectors.joining("   ", (boardRow[i]) + "⎟", "  ")));
            build.append("\n");
        }
        // print a board with my Stringbuilder 'build'.
        System.out.println((build.toString()));

    }

}