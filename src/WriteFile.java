import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by praveen on 18/03/17.
 */
public class WriteFile {

    private String fileName;
    private EntryHashMap entryHashMap;

    WriteFile(String fileName, EntryHashMap entryHashMap){
        this.fileName = fileName;
        this.entryHashMap =entryHashMap;
    }

    public void writeToFile()throws IOException {
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        List<String> allKeys = entryHashMap.listAllKeys();

        for(String key : allKeys){
            writer.println(key + " " + entryHashMap.find(key));
        }

        writer.close();
    }
}
