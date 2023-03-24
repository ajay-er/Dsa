package Hash;

import java.util.*;

public class HashMap1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // insert
        map.put("Ajay", 23);
        map.put("Kasi", 19);
        map.put("Joel", 24);
        System.out.println(map);
        map.put("Joel", 25);
        System.out.println(map);

        // search
        System.out.println(map.containsKey("Ajay"));//returns boolean

        //geting values
        System.err.println(map.get("Ajay"));//prints the value
        System.out.println(map.get("ajmal"));//returns null 
        System.out.println();


        //iterate in hashmap
        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        
        //another iteration
        Set<String> keys = map.keySet();
        for(String key: keys){
            System.out.println(key+" "+ map.get(key));
        }

        //remove
        map.remove("Ajay");
        System.out.println(map);
    }
}
