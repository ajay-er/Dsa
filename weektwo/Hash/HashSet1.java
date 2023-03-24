package Hash;

import java.util.HashSet;
import java.util.Iterator;

public class HashSet1 {
    public static void main(String[] args) {
        // creating
        HashSet<Integer> set = new HashSet<>();

        // add
        set.add(2);
        set.add(1);
        set.add(3);
        System.out.println(set);
        

        Iterator it = set.iterator();
        // System.out.println(it.hasNext());
        // System.out.println(it.next());
        // System.out.println(it.next());
        // System.out.println(it.next());

        // value contains or not
        System.out.println(set.contains(32));//returns boolean

        // printing all elements
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
