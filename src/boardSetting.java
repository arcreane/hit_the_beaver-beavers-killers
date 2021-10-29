/**
 * 0️⃣1️⃣2️⃣3️⃣4️⃣5️⃣6️⃣7️⃣8️⃣9️⃣🔟
 * 🟦
 * 🔹
 * 🐼🐭🐨
 */

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class boardSetting {
    static int timer = 0;
    static int height = 0;
    static String[] boardRow = new String[10];
//    static String[] boardCol = new String[10];

    public static  void fillUp() {
        if (getPlayerEntry.board_Mode == 1) {
            for (int i = 0; i < 10; i++) {
                boardRow[i] = Integer.toString(i);
            }
        } else {
            boardRow[0] ="0️⃣";
            boardRow[1] ="1️⃣";
            boardRow[2] ="2️⃣";
            boardRow[3] ="3️⃣";
            boardRow[4] ="4️⃣";
            boardRow[5] ="5️⃣";
            boardRow[6] ="6️⃣";
            boardRow[7] ="7️⃣";
            boardRow[8] ="8️⃣";
            boardRow[9] ="9️⃣";
        }
    }


    public static String[][] createBoard() {
        System.out.println("Select level");
        height = 0;
        timer = 0;
        String menu = """
                1 : Easy
                2 : Medium
                3 : Hard""";
        String level = getPlayerEntry.get_usr_choice(menu, "1", "2", "3");
        switch (level) {
            case "1":
                height = 5;
                if (getPlayerEntry.usr_level.equals("Rookie")) timer = 8000;
                else timer = 5000;
                break;
            case "2":
                height = 7;
                if (getPlayerEntry.usr_level.equals("Rookie")) timer = 7000;
                else timer = 4000;
                break;
            case "3":
                height = 10;
                if (getPlayerEntry.usr_level.equals("Rookie")) timer = 5000;
                else timer = 3500;
        }
        String[][] board = new String[height][height];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = getPlayerEntry.Cell_icon;
            }
        }
        if (!level.equals("Q")) return board;
        else return null;
    }

    public static void displayBoard(String[][] board) {
        StringBuilder build = new StringBuilder();
        build.append("  ");
        for (int i = 0; i < board.length; i++) {
            build.append(boardRow[i] + "   ");
        }
        build.append("\n");
        for (int i = 0; i < board.length; i++) {
            build.append("_____");
        }
        build.append("\n");
        for (int i = 0; i < board.length; i++) {
            build.append(Stream.of(board[i])
                    .collect(Collectors.joining("   ", (boardRow[i]) + "⎟", "  -")));
            build.append("\n");
        }
        System.out.println((build.toString()));
    }

}






