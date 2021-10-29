import java.io.*;

public class Score {
    /**
     * Searches for fileName.txt file and reads it line by line to
     * @param fileName
     * @return an array of Strings.
     */
    public static String[][] getSavedScore(String fileName){
        String[][] inputFile = new String[15][2];

        // Create a file object
        File file = new File(fileName);

        // Get the absolute path of file
        String absolute = file.getAbsolutePath();

        try {
            FileReader reader = new FileReader(absolute);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            int row = 0;
            while ((line = bufferedReader.readLine()) != null && row<15) {
                String[] data = line.split(" ");
                for(int i = 0; i<2; i++)
                    inputFile[row][i] = data[i];
                row++;
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputFile;
    }

    /**
     * Gets FileName.txt and rewrites it with the new high scores.
     * @param fileName
     * @param outputFile
     */
    public static void overwriteScores (String fileName, String[][] outputFile){
        File file = new File(fileName);
        String absolute = file.getAbsolutePath();
        try {
            FileWriter writer = new FileWriter(absolute, false); // true to append
            // false to overwrite.
            for(String[] row:outputFile){
                writer.write(row[0]+" "+row[1] +"\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
