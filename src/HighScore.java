
import java.util.Scanner;

public class HighScore {

    // Creation of the scores array
    static public String[][] m_scoreArray = new String[15][2];

    public static void display_High_Scores() {
        String level = "";
        int tabIndex = 0;
        System.out.println("****** HIGH SCORES ******");
        switch (boardSetting.height){
            case 5 -> {
                level = "Easy";
                tabIndex = 10;}
            case 7 -> {
                level = "Medium";
                tabIndex = 5;
            }
            case 10 -> {
                level = "Hard";
                tabIndex = 0;
            }
        }
        print_Scores(tabIndex, level);
    }

    public static void print_Scores(int index, String level){
        System.out.println("-----"+level+" Level -----");
        for (int i = index; i < index+5; i++)
            System.out.println("Name: " + m_scoreArray[i][0] + " " + m_scoreArray[i][1]);
    }

    public static void init_HighScores() {
        String[][] savedScores = Score.getSavedScore("savedScores.txt");
        for (int i = 0; i < 15; i++) {
            m_scoreArray[i][0] = savedScores[i][0];
            m_scoreArray[i][1] = savedScores[i][1];
        }
    }

    public static int check_position(int score) {
        int tabIndex = 0;
        switch (boardSetting.height){
            case 5 -> tabIndex = 10;
            case 7 -> tabIndex = 5;
            case 10 -> tabIndex = 0;
        }
        int place = 5;
        for (int i = tabIndex; i < tabIndex+5; i++) {
            if (score > Integer.parseInt(m_scoreArray[i][1])) {
                place = i-tabIndex;
                break;
            }
        }
        return place;
    }

    public static void Sort_Winners(int position, int points, String name) {
        int tabIndex = 0;
        switch (boardSetting.height){
            case 5 ->{
                tabIndex = 14;
                position += 10;
            }
            case 7 ->{
                tabIndex = 9;
                position += 5;
            }
            case 10 ->{
                tabIndex = 4;
                position = 0;
            }
        }

        for (int i = tabIndex; i > position; i--) {
            m_scoreArray[i][0] = m_scoreArray[i - 1][0];
            m_scoreArray[i][1] = m_scoreArray[i - 1][1];
        }
        m_scoreArray[position][0] = name;
        m_scoreArray[position][1] = Integer.toString(points);
        Score.overwriteScores("savedScores.txt", HighScore.m_scoreArray);
    }

    public static String define_Name() {
        String name = "";
        String confirm = "y";
        Scanner scan = new Scanner(System.in);
        while (confirm == "y" || confirm == "Y") {
            System.out.println("Enter your name : ");
            name = scan.nextLine();
            System.out.println("Your name is : " + name);
            System.out.println("Confirm y/n: ");
            confirm = scan.nextLine();
            if (confirm.equals("")) confirm = "y";
        }
//        scan.close();
        return name;
    }

}





