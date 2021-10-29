import java.util.Timer;
import java.io.*;

public class AnswerOnTime {
    static private String str = "";
    static private int time_Span;

//    static TimerTask task = new TimerTask() {
////        @Override
//        public void run() {
//            if (str.equals("")) {
//                System.out.println("Too late. Next try...");
//                System.exit(0);
//            }
//        }
//    };

    public static void getInput() throws Exception {
        Timer timer = new Timer();
        timer.schedule(new CustomTimer(), 5*1000);

        System.out.println("Input a string within 5 seconds: ");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        str = in.readLine();

//        timer.cancel();
//        System.out.println("you have entered: " + str);
    }

    public static String Coord_Idle (int Timelapse) {
        time_Span=Timelapse;
        try {
            getInput();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("main exit...");
        return str;
    }
}
