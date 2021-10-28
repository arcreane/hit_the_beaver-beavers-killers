import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class boardSetting {
    public static int[] createBoard() {
        System.out.println("Select level");
        int[] board_Param = new int[2];
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


        StringBuilder build = new StringBuilder();
        String[][] board = new String[height][height];

        for (int i = 0; i < board.length + 1; i++) {
            build.append(1 + "   ");
        }
        build.append("\n");
        for (int i = 0; i < board.length + 1; i++) {

            build.append("___");
        }
        build.append("\n");
        for (int i = 0; i < height; i++) {
            build.append(Stream.of(board[i])
                    .collect(Collectors.joining()));
            System.out.println(Arrays.toString(board[i]));
        }
        board_Param[0] = timer;
        board_Param[1] = height;
        return board_Param;

    }


}



