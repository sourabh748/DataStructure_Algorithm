package Collection.MapGenerics;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
         this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        /*
         * Returns true if this map should remove its eldest entry. 
         * This method is invoked by put and putAll after inserting a new entry into the map. 
         * It provides the implementor with the opportunity to remove the eldest entry each time a new one is added. 
         * This is useful if the map represents a cache: it allows the map to reduce memory consumption by deleting stale entries.
         */
        return size() > this.capacity;
    }

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(3);

        cache.put("Bob", 73);
        cache.put("Alice", 93);
        cache.put("Andy", 70);
        System.out.println(cache.get("Bob"));
        cache.put("Vance", 80);

        for( Map.Entry<String, Integer> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + " "+ entry.getValue());
        }
    }
}
