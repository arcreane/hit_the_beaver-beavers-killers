/**
 * 0️⃣1️⃣2️⃣3️⃣4️⃣5️⃣6️⃣7️⃣8️⃣9️⃣🔟
 * 🟦
 * 🔹
 * 🐼🐭🐨
 */

import java.util.Scanner;

public class getPlayerEntry {
    static int board_Mode = 0;
    static String Cell_icon = "+";
    static String usr_level="Rookie";
    static String Marmot_icon =  "✖︎";

    static int[] getcoordEntry(int height) {
        //Return a valid Player entry for game loop, whatever the entry is
        int[] entry = new int[2];
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);
        outter:
        do {
            System.out.println("Where is the beaver, enter number coordinates as : line column.\nExample : 0 1");
            for (int i = 0; i < 2; i++) {
                int number;
                try {
                    number = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("No valid entry!");
                    scanner.nextLine();
                    continue outter;
                }
                entry[i] = number;
            }
            if (entry[0] <= height && entry[1] <= height)
                valid = true;
        } while (!valid);
        scanner.nextLine();
        //
        //System.out.println(Arrays.toString(entry));
        return entry;
    }

    public static void Preferences() {
        System.out.println("Select Option");
        String menu = """
                1 : Switch board to Texte/EMOJI
                2 : Display last Log
                3 : User level (Rookie, Expert)
                """;
        String level = get_usr_choice(menu, "1", "2", "3");
        switch (level) {
            case "1":
                if (board_Mode ==2){
                board_Mode = 1;
                Cell_icon = "●";
                Marmot_icon = "☺︎";
                boardSetting.fillUp();
                break;}
                else{
                board_Mode = 2;
                Cell_icon = "🟦";
                Marmot_icon = "🐼";
                boardSetting.fillUp();
                break;
                }
            case "2": {
                GamePlay.display_Log();
                break;
            }
            case "3":
                menu= """
                        -1: Rookie
                        -2: Expert
                        -3: Superman""";
                level = get_usr_choice(menu, "1", "2", "3");
                switch (level){
                    case "1": {
                        usr_level = "Rookie";
                        break;
                    }
                    case "2": {usr_level="Expert";
                        break;}
                    case "3":
                        System.out.println("SORRY: not Implemented yet");
                }

        }
    }

    static String get_usr_choice(String menuList, String A, String B, String C) {
        /*
        Displays possibles choices and make sure that it is a valid choice.
         */
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println(menuList);
            System.out.println("Type your choice :");
            choice = scanner.nextLine();
            if (!(choice.equals(A) || choice.equals(B) || choice.equals(C) || choice.equals("Q")))
                System.out.println("Please enter a valid choice.\n");
        }
        while (!(choice.equals(A) || choice.equals(B) || choice.equals(C) || choice.equals("Q")));
        return choice;
    }
}
