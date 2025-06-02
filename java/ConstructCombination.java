import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructCombination {
    public static boolean canConstruct(String target, String[] wordbank) {
        if ( target.equals(""))
            return true;

        for ( String word: wordbank) {
            if ( target.indexOf(word, 0) == 0) {
                String suffix = target.substring(word.length());
                if ( canConstruct(suffix, wordbank) == true)
                    return true;
            }
        }
        return false;
    }

    public static boolean canConstructTabulation(String target, String[] wordbank) {

        int targetlength = target.length();

        boolean[] table = new boolean[targetlength + 1];
        Arrays.fill(table, false);

        // Base Case
        table[0] = true;

        for( int index= 0; index <= targetlength; index++) {
            if ( table[index] ) {
                for( String word: wordbank) {
                    int length = word.length();

                    if ( index + length <= targetlength && target.substring(index, index + length).equals(word)) {
                        table[index + length] = true;
                    }
                }
            }
        }
        return table[targetlength];
    }

    public static int countConstruct(String target, String[] wordbank, Map<String, Integer> memo) {
        if ( memo.containsKey(target)) return memo.get(target);
        if ( target.equals("")) return 1;

        int totalCOnstruct = 0;

        for ( String word: wordbank) {
            if ( target.indexOf(word, 0) == 0) {
                String suffix = target.substring(word.length());
                if ( countConstruct(suffix, wordbank, memo) == 1)
                    totalCOnstruct += 1;
            }
        }
        memo.put(target, totalCOnstruct);
        return totalCOnstruct;
    }

    public static int countConstructTabulation(String target, String[] wordbank) {

        int targetlength = target.length();

        int[] counts = new int[targetlength];
        Arrays.fill(counts, 0);

        for( int index =0; index <= targetlength; index++) {
            if ( counts[index] != 0 ) {
                for( String word: wordbank) {
                    int length = word.length();
                    if ( index + length <= targetlength && target.substring(index, index + length).equals(word)) {
                        counts[index + length] += counts[index];
                    }
                }
            }
        }

        return counts[targetlength];
    }

    public static List<List<String>>allConstruct(String target, String[] wordbank, Map<String, List<List<String>>> memo) {
        if ( memo.containsKey(target)) return memo.get(target);
        if ( target.equals("") ) {
            List<List<String>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }

        List<List<String>> result = new ArrayList<>();

        for ( String word: wordbank ) {
            if ( target.indexOf(word, 0) == 0) {

                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix, wordbank, memo);

                for( List<String> ways : suffixWays) {
                    List<String> combination = new ArrayList<>();
                    combination.add(word);
                    combination.addAll(ways);
                    result.add(combination);
                }
            }
        }

        memo.put(target, result);
        return result;
    }

    public static void main(String[] args) {

        // String[] wordbank = new String[] {"ab", "abc", "cd", "def", "abcd"};
        // String target = "abcdef";

        String[] wordbank = new String[] {"purp", "p", "ur", "le", "purpl"};
        String target = "purple";

        Map<String, List<List<String>>> memo = new HashMap<>();

        System.out.println(allConstruct(target, wordbank, memo));

    }
}