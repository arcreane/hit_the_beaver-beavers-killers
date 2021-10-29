import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * GamePlay class manage the game time once the difficulty level is defined
 */

public class GamePlay {
    static boolean input_Done = true;
    static int myTurns; // current turns on 10 to be played
    static int lin = 0; // lin is x pos for the Marmot
    static int col = 0; // lin is y pos for the Marmot
    //    static String str = "";
    static int lapse;   // time length for the timer
    static int beaverTurns = 10;    // 10 rounds for each game
    static int x_coordinate = 0;    // x pos entered by the gamer
    static int y_coordinate = 0;    // y pos entered by the gamer
    static String usr_Speed = "";
    static String[] game_log = new String[10];

    /**
     * setMarmot updates a new random pos for the Marmot    *
     *
     * @param board_dim Game board dimensions
     * @param board     current board being played
     * @return return the updated board
     */
    public static String[][] setMarmot(int board_dim, String[][] board) {
/**
 */
        //        System.out.println("dimension tableau "+ board_dim);
        board[lin][col] = getPlayerEntry.Cell_icon; // re_initialise the previous Marmot pos
        lin = (int) (Math.random() * (board_dim - 1) + 1);// set a random pos for the Marmot (same for next)
        col = (int) (Math.random() * (board_dim - 1) + 1);
//        System.out.println(("lin/col :"+lin+"/"+col));
        board[lin][col] = getPlayerEntry.Marmot_icon; //sets the icon of the Marmot at new pos
        System.out.println("Round : " + myTurns);// display the current round to the gamer
        return board;
    }

    /**
     * wait for 'lapse' time an input from the gamer
     * got the help of Julien to set this function/Method.
     *
     * @return returns true if answer is relevant, false otherwise.
     * @throws IOException manage eventual bad input
     */
    public static boolean Usr_shoot() throws IOException {
        String[] coordinates_input = new String[2];
        long spent_Time = 0;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hit the Beaver !");
        System.out.print("Enter: x y (space) :");

        long startTime = System.currentTimeMillis();// init of starting time
        while ((System.currentTimeMillis() - startTime) < lapse &&
                !in.ready()) {
            spent_Time = System.currentTimeMillis() - startTime;
        }// wait for the timeout or usr input to exit while loop
        System.out.println("timeout: " + spent_Time);
        if (in.ready()) {
            coordinates_input = in.readLine().split(" ");
            try {   //verify input if compliant with coordinates
                x_coordinate = Integer.parseInt(coordinates_input[0]);
                y_coordinate = Integer.parseInt(coordinates_input[1]);
            } catch (Exception e) {
                System.out.println("No valid entry!");
                return false; // false if no coordinates are set
            }
            return true;// true if relevant coordinates are set
        } else {
            System.out.println("Too late, too slow ...");
            return false;// false if usr waited too long to answer.
        }
    }

    /**
     * Displays the last game details : hit/miss ...
     */
    public static void display_Log() {
        System.out.println("\nYour last Game Summary:");
        for (int i = 0; i < 10; i++) {
            System.out.println(game_log[i]);
        }
        System.out.println("---\n");
    }

    /**
     * initialise the game_log array
     */
    public static void init_Log() {
        for (int i = 0; i < 10; i++) {
            game_log[i] = "-" + i + ": ";
        }
    }

    /**
     * Update the game log at myTurns
     * @param score     current score at round my Turns
     * @param hit_miss  message to be added : hit/miss/bad one
     */
    public static void update_Log(int score, String hit_miss) {
        game_log[myTurns] = game_log[myTurns] + lin + "/" + col + " vs " + x_coordinate +
                "/" + y_coordinate + hit_miss + score + "/10 - time :" + usr_Speed;
    }

    /**
     * Operate the 10 rounds for a game (display, updates Marmots and manage usr answers
     * @throws IOException
     */
    public static void playRounds() throws IOException {
        String[][] player_board = boardSetting.createBoard();
        int game_Score = 0;
        int score_position = 5;
        String gamer_name = "";
        lapse = boardSetting.timer;
        init_Log();
        if (!(player_board == null)) { // null is returned if the player wants to stop the game
            for (int myTurns = 0; myTurns < beaverTurns; myTurns++) { // loop for 10 rounds
                player_board = setMarmot(boardSetting.height, player_board);// update Marmot pos
                boardSetting.displayBoard(player_board);// display the new board
                if (Usr_shoot()) {// player input evaluation
                    if (x_coordinate == lin && y_coordinate == col) {
                        System.out.println("HIT HIT HIT HOURRA !");
                        game_Score++;
                        update_Log(game_Score, "Hit:");
                    } else {
                        System.out.println("MISSED: try again !");
                        update_Log(game_Score, "Miss:");
                    }
                } else
                    update_Log(game_Score, "Bad/No input:");
            }
        }
        System.out.println("Game Over ...");
        // verifies if the score allows to high score application
        score_position = HighScore.check_position(game_Score);
        System.out.println("position au High Score: " + score_position);
        if (score_position < 4) { //condition to be in High Score list
            gamer_name = HighScore.define_Name(); // define a winner name
            HighScore.Sort_Winners(score_position, game_Score, gamer_name);// sort the score list
            HighScore.display_High_Scores(); // display the High Score list
            display_Log();
        }
    }
}
//TRASH (before game over msg
//            str = AnswerOnTime.Coord_Idle(lapse);
//            if (input_Done) System.out.println("vous avez entré : " + str);
//            else System.out.println("Bad news you've been too long ...");
