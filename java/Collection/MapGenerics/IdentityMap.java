package Collection.MapGenerics;

import java.util.IdentityHashMap;

public class IdentityMap {
    public static void main(String[] args) {

        // Identity HashMap works with Identity Hash Code toStore Information in the HashMap hear memory Address are compared over
        // hashCode() function i.e, == operator is used to compare the object over the .equals() function.
        IdentityHashMap<String, Integer> map = new IdentityHashMap<>();

        String key1 = new String("key1");
        String key2 = new String("key1");

        System.out.println(System.identityHashCode(key1));
        System.out.println(System.identityHashCode(key2));

        map.put(key1, 7);
        map.put(key2, 10);

        System.out.println(map);
    }
}
