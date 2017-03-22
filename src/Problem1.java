import java.io.IOException;

/**
 * Created by praveen on 18/03/17.
 */
public class Problem1 {

    public static void main(String[] args)throws IOException{
        String fileNameRead = "YOUR-FILE-PATH";
        String fileNameWrite = "YOUR-FILE-PATH";

        Problem1 problem1 = new Problem1();
        problem1.performOperations(fileNameRead, fileNameWrite);
    }

    public void performOperations(String fileNameRead, String fileNameWrite)throws IOException{
        ReadFile readFile = new ReadFile(fileNameRead);
        readFile.readDetailsFromFile();
        WriteFile writeFile = new WriteFile(fileNameWrite, readFile.getEntryHashMap());

        writeFile.writeToFile();

    }

}
