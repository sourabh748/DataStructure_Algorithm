import java.util.HashMap;
import java.util.Map;

public class MemoizationAndCaching {
    private static Map<Long, Long> cache = new HashMap<>();  // Memoization and caching ( Recursion Optimization ) to reduce the call Stack

    public static long fib(long n){
        if (n == 0 || n == 1)
            return n;
        if(cache.containsKey(n))
            return cache.get(n);
        long result = fib(n -1) + fib(n -2);
        cache.put(n, result);
        return result;
    }
}
