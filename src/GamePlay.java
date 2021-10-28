import java.util.Timer;
import java.util.TimerTask;
import java.io.*;

public class GamePlay {
    static boolean input_Done = true;
    static int myTurns;
    static int staticID = 0;
    static int lin = 0;
    static int col = 0;
    static private String str = "";
    static private int lapse;
    static int beaverTurns = 10;

//    static TimerTask task = new TimerTask() {
//        public void run() {
//            if (str.equals("")) {
//                System.out.println("Time out overrun. next board ...");
//                input_Done = false;
//                System.exit(0);
//            }
//        }
//    };

    public static String[][] create_boards(int board_dim) {
        String[][] player_board = new String[board_dim][board_dim];
        for (int i = 0; i < board_dim; i++) {
            for (int j = 0; j < board_dim; j++) {
                player_board[i][j] = "🟦";
            }
        }
        return player_board;
    }

    public static void display_board(int board_dim, int current_Turn, String[][] board) {
        board[lin][col] = "🟦";
        lin = (int) (Math.random() * (board_dim-1)+1);
        col = (int) (Math.random() * (board_dim-1)+1);
        String text_row;
        board[lin][col] = "🐼";
        System.out.println("Round : " + current_Turn);
        System.out.println("   0  1  2  3  4  5  6  7  8  9");
        for (int i = 0; i < board_dim; i++) {
            text_row = "";
            for (int j = 0; j < board_dim; j++) {
                text_row = text_row + " " + board[i][j];
            }
            if (i < 9) System.out.println("0" + (i + 1) + " " + text_row);
            if (i == 9) System.out.println("10" + " " + text_row);
        }
    }

//    public static void getInput() throws Exception {
//        Timer timer = new Timer();
//        timer.schedule(task, lapse * 1000);
//
//        System.out.println("Input coordinates within " + lapse + " seconds: ");
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(System.in));
//        str = in.readLine();
//        timer.purge();
//        System.out.println("timer.purge");
//        timer.cancel();
//        System.out.println("timer.cancel");
////        System.out.println( "you have entered: "+ str );
//    }

//    public static void CurrentTurn() {
//        try {
//            getInput();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }


    public static void Timer() {
       int[] board_Param = boardSetting.createBoard();
        lapse= board_Param[0];
        String[][] play_board = create_boards(board_Param[1]);
//        String[][] gameResult = new String[10][10];
        for (int myTurns = 0; myTurns < beaverTurns; myTurns++) {
            display_board(board_Param[1], myTurns, play_board);
            str=AnswerOnTime.Coord_Idle(lapse);
            //            CurrentTurn();
            if(input_Done) System.out.println("vous avez entré : "+ str);
            else System.out.println("Bad news you've been too long ...");
        }
        System.out.println("Game Over ...");
    }
}

