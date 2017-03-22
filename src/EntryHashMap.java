import java.util.ArrayList;
import java.util.List;

/**
 * Created by praveen on 18/03/17.
 */
public class EntryHashMap {

    private int BUCKET_ARRAY_SIZE = 256;
    private Entry bucketArray[] = new Entry[BUCKET_ARRAY_SIZE];

    public EntryHashMap(){}

    public EntryHashMap(int initialSize){
        this.BUCKET_ARRAY_SIZE = initialSize;
    }

    public void insert(String key, int value){
        int hash = createHashValueByString(key) % BUCKET_ARRAY_SIZE;

        Entry entry = new Entry(key,value);

        if(bucketArray[hash] == null){
            bucketArray[hash] = entry;
        }else{
            Entry current = bucketArray[hash];
            Entry temp = current;
            while(current.next != null){
                if(current.getKey().equals(entry.getKey())){
                    current.setValue(entry.getValue());
                    bucketArray[hash] = temp;
                    return;
                }
                current = current.next;
            }
            current.next = entry;
            bucketArray[hash] = temp;
        }
    }

    public int find(String key){
        int hash = createHashValueByString(key) % BUCKET_ARRAY_SIZE;
        Entry n = bucketArray[hash];
        Entry temp = n;
        while(n != null){
            if(n.getKey().equals(key)){
                return n.getValue();
            }
            n = n.getNext();
        }
        bucketArray[hash] = temp;
        return 0;
    }

    public void increase(String key){
        int hash = createHashValueByString(key) % BUCKET_ARRAY_SIZE;
        if(bucketArray[hash] != null){
            Entry current = bucketArray[hash];
            Entry temp = current;
            while(current != null) {
                if (current.getKey().equals(key)) {
                    current.setValue(current.getValue() + 1);
                    bucketArray[hash] = temp;
                    return;
                }
                current = current.next;
            }
        }
    }

    public void delete(String key){
        int hash = createHashValueByString(key) % BUCKET_ARRAY_SIZE;
        if(bucketArray[hash] != null){
            Entry current = bucketArray[hash];
            Entry temp = current;
            while(current.next != null) {
                if (current.getKey().equals(key)) {
                    current.setKey(current.next.getKey());
                    current.setValue(current.next.getValue());
                    current.next = current.next.next;
                    bucketArray[hash] = temp;
                    return;
                }
                current = current.next;
            }
            bucketArray[hash] = temp;
        }
    }

    public List<String> listAllKeys(){
        List<String> allKeys = new ArrayList<>();
        for (Entry entry:bucketArray) {
            if(entry != null) {
                allKeys.add(entry.getKey());
                while (entry.next != null) {
                    entry = entry.next;
                    allKeys.add(entry.getKey());
                }
            }
        }
        return allKeys;
    }

    private int createHashValueByString(String input){
        int hash = 0;
        if(input!=null && !input.isEmpty()){
            hash = 7;
            for (int i = 0; i < input.length(); i++) {
                hash = hash*31 + input.charAt(i);
            }
        }
        return Math.abs(hash);
    }
}
