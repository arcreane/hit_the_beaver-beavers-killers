import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Score {
    public static String[] getSavedScore(String fileName){
        String[] inputFile = new String[5];

        // Create a file object
        File f = new File(fileName);

        // Get the absolute path of file f
        String absolute = f.getAbsolutePath();

        try {
            FileReader reader = new FileReader(absolute);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            int row = 0;
            while ((line = bufferedReader.readLine()) != null) {
                inputFile[row++] = line;
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputFile;
    }
}
