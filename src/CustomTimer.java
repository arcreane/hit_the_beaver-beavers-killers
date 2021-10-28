import java.util.TimerTask;

public class CustomTimer extends TimerTask {
    int timecount=5;
    String str ="";

    @Override
    public void run() {
        System.out.println("Timer : "+timecount);
        if (str.equals("")) {
            System.out.println("Too late. Next try...");
            System.exit(0);
        }
        if(timecount==0){
            cancel();
        }
    timecount--;
    }
}
