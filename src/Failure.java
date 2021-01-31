import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ConcurrentModificationException;

public class Failure {
    ArrayList<Integer> ids;
    ConcurrentHashMap<String, Integer> map;

    private void fastTest() {
        System.out.println("Original size: " + ids.size());

        Iterator<Integer> iterator = ids.iterator();
        int i;
        while (iterator.hasNext()) {
            i = iterator.next();
            if (i == 4 || i == 5) {
                iterator.remove();
                System.out.println("Removed an element by Iterator's remove() => size: " + ids.size());
            }
        }

        iterator = ids.iterator();
        try{
            while (iterator.hasNext()) {
                if (iterator.next() == 3) {	// Throws exception when it runs after remove() executes once.
                    ids.remove(2); // Removes correctly once.
                    System.out.println("Removed an element by Collection's remove() => size: " + ids.size());
                }
            }
        }
        catch(ConcurrentModificationException e){
            System.out.println("Exception thrown because of concurrent modification!!\n");
        }

    }
    private void safeTest() {
        Iterator<String> iterator = map.keySet().iterator();

        int i = 0;
        try {
            while (iterator.hasNext()) {
                String key = iterator.next();
                if(key.equals("Third"))
                    System.out.println("Removed element from map: " + map.remove("Third"));
            }
        }
        catch(ConcurrentModificationException e) {
            System.out.println("Exception thrown for modifying a ConcurrentHashMap");
        }
    }
    public static void main(String[] args) {
        Failure f = new Failure();
       // f.fastTest();
        f.safeTest();
    }
    Failure(){
        ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        ids.add(5);

        map = new ConcurrentHashMap<>();
        map.put("First", 10);
        map.put("Second", 20);
        map.put("Third", 30);
        map.put("Fourth", 40);
    }
}