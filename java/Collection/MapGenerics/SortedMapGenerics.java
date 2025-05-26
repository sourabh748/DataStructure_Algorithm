package Collection.MapGenerics;

import java.util.TreeMap;
// import java.util.Map;
// import java.util.SortedMap;

public class SortedMapGenerics {
    public static void main(String[] args) {
        TreeMap<Integer, String> sm = new TreeMap<>();

        sm.put(99, "Sourabh suman");
        sm.put(80, "vipul");
        sm.put(50, "gourav");

        System.out.println(sm.firstKey());
    }
}