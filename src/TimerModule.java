import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TimerModule {
    static boolean canWrite = true;
    static int turns = 10;
    public static void Timer(int timelapse) {
        Timer gt = new Timer();
        gt.schedule(new TimerTask() {
            @Override
            public void run() {
                Timer t = new Timer();
                TimerTask tt = new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Entrer les Coordonnées");
                        Scanner sc = new Scanner(System.in);
                        String tmp = sc.nextLine();
                        if(canWrite)
                            System.out.println("Vrai");
                        else
                            System.out.println("too late");
                    }
                };
                t.schedule(tt,0);
                try {
                    Thread.sleep(timelapse);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                canWrite = false;
                System.out.println("Time's up");
            }
        },0);

    }
}