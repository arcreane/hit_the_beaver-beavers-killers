import java.util.Scanner;

public class HighScore {

    // Creation of the scores array
    static public String[][] m_scoreArray = new String[5][2];

    public static void affiche_High_Score() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Nom: " + m_scoreArray[i][0] + " " + m_scoreArray[i][1]);
        }
    }

    public static void init_HighScores() {
        for (int i = 0; i < 5; i++) {
            m_scoreArray[i][0] = "toto" + i;
            m_scoreArray[i][1] = "0";
        }
    }

    public static int verif_position(int score) {
        int place = 5;
        for (int i = 0; i < 5; i++) {
            if (score > Integer.parseInt(m_scoreArray[i][1])) {
                place = i;
                break;
            }
        }
        return place;
    }

    public static void Sort_Winners(int position, int points, String name) {
        String tmp1 = m_scoreArray[position][0];
        String tmp2 = m_scoreArray[position][1];

        for (int i = 4; i > position; i--) {
            m_scoreArray[i][0] = m_scoreArray[i - 1][0];
            m_scoreArray[i][1] = m_scoreArray[i - 1][1];
        }
        m_scoreArray[position][0] = name;
        m_scoreArray[position][1] = Integer.toString(points);
    }

    public static void Scoring_function() {
        String name = "";
        int rank = 0;
        int points = 0;
        int position = 0;

        System.out.println("High Score Display");
        Scanner scan = new Scanner(System.in);
        init_HighScores();
        affiche_High_Score();
        for (int test = 0; test < 4; test++) {
            points = (int) (Math.random() * 9 + 1);
            position = verif_position(points);
            System.out.println("position = " + position);
            if (position < 5) {
                System.out.println("Enter your name : ");
                name = scan.nextLine();
                Sort_Winners(position, points, name);
            }
            affiche_High_Score();
        }
    }
}





