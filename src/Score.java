import java.io.*;

public class Score {
    public static String[][] getSavedScore(String fileName){
        /**
         * Searches for fileName.txt file and converts it into an array of Strings.
         */
        String[][] inputFile = new String[5][2];

        // Create a file object
        File file = new File(fileName);

        // Get the absolute path of file
        String absolute = file.getAbsolutePath();

        try {
            FileReader reader = new FileReader(absolute);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            int row = 0;
            while ((line = bufferedReader.readLine()) != null && row<2) {
                String[] data = line.split(" ");
                for(int i = 0; i<2; i++)
                    inputFile[row++][i] = data[i];
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputFile;
    }

    public static void overwriteScores (String fileName, String[][] outputFile){
        /**
         * Gets FileName.txt and rewrites it with the new high scores.
         */
        File file = new File(fileName);
        String absolute = file.getAbsolutePath();
        try {
            FileWriter fooWriter = new FileWriter(absolute, false); // true to append
            // false to overwrite.
            for(String[] row:outputFile){
                fooWriter.write(row[0]+" "+row[1] +"\n");
            }
            fooWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
