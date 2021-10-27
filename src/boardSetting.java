public class boardSetting {
    public static void createBoard() {
        System.out.println("Select level");
        int height=0;
        int timer = 0;
        String menu= """
                1 : Easy
                2 : Medium
                3 : Hard
                """;
     //   int level=get_usr_input(menu,'1','2','3');
        switch (get_usr_input(menu,'1','2','3')) {
            case 1:
                height = 5;
                timer = 4000;
            case 2:
                height = 7;
                timer = 3500;
            case 3:
                height = 10;
                timer = 3000;
        }
        String [][]board = new board [height][height];




    }


}



