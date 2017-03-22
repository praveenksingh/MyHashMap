import java.io.*;

/**
 * Created by praveen on 18/03/17.
 */
public class ReadFile {

    private EntryHashMap entryHashMap;
    private String fileName;

    ReadFile(String fileName){
        this.entryHashMap = new EntryHashMap();
        this.fileName = fileName;
    }

    void readDetailsFromFile()throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");
                for (String str : tokens) {
                    str = str.toLowerCase();
                    if (entryHashMap.find(str) != 0) {
                        entryHashMap.increase(str);
                    } else {
                        entryHashMap.insert(str, 1);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public EntryHashMap getEntryHashMap() {
        return entryHashMap;
    }
}
