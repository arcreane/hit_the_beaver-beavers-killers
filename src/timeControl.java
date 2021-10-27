import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class timeControl {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public boolean timeBufferReady() throws IOException {
        while (!reader.ready()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    public static void mainTimeLoop(long timeLaps){
        long timer = System.currentTimeMillis(); //on récupère le temps d’exécution du programme au lancement du timer
        long delay = timeLaps; //on veut attendre 2000 ms

        while (System.currentTimeMillis() - timer < delay) //tant que le temps écoulé depuis qu'on a initialisé le timer est inférieur au delay
        {
            System.out.println("continuer "+System.currentTimeMillis()); //le programme s’exécute
        }
//        return 2000;
//        Scanner sc = new Scanner(reader);
//        if (timeBufferReady==true);
//       do{
//          time = sc.nextLine();
//            System.out.println("time is "+time);
//        }while (time != "100000");
    }
}

/**
 * long timer = System.currentTimeMillis(); //on récupère le temps d’exécution du programme au lancement du timer
 * int delay = 2000; //on veut attendre 2000 ms
 *
 * while (System.currentTimeMillis() - timer < delay) //tant que le temps écoulé depuis qu'on a initialisé le timer est inférieur au delay
 * {
 *     System.out.println("continuer"); //le programme s’exécute
 * }
 */