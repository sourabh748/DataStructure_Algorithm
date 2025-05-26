package Collection.ListGeneric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * A collection represent object that is group of objects, knows as elements.
 * 
 * key Interfaces in collection Frameworks are :- 
 * @ Collection Interface - The root Interface for all collection type.
 * @ List - An ordered Collection that contains duplicates elements ( eg ArrayList, LinkedList ).
 * @ Set - A collection that cannot contain duplicate elements (e.g., HashSet, TreeSet).
 * @ Queue - A collection designed for holding elements prior to processing (e.g., PriorityQueue, LinkedList when used as a queue).
 * @ Deque - A double-ended queue that allows insertion and removal from both ends (e.g., ArrayDeque).
 * @ Map - An interface that represents a collection of key-value pairs (e.g., HashMap, TreeMap).
 * 
 * Internally, the ArrayList implemented as an array of Object references.
 * When you add element to an ArrayList, you're essentially storing the elements in the internal array.
 * 
 * when we create an ArrayList it has an initial capacity (default 10). The capacity refers to the size of the internal array
 * that can hold the element before needing to resize.
 */


class StringLengthComperator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {

        /*
            if return value is -ve then o1 will comes before o2
            if return value is 0 then ordering of o1 and o2 are same
            if return value is +ve then o2 will comes before o1
        */
        return o1.length() - o2.length();
    }
    
}

public class ArrayListGeneric {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(11);

        // System.out.println(list);

        // This is Immutable list which only supports data updatation but not data insertion or deletion
        Arrays.asList(1, 3, 5, 2, 7, 3, 4, 9, 1); 

        list.add(10);

        list.addAll(List.of(1, 3, 5, 2, 7, 3, 4, 9, 1));

        System.out.println(list);

        list.remove(Integer.valueOf(1));

        List<String> words = Arrays.asList("banana", "apple", "date");

        // words.sort(new StringLengthComperator());
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            };
        });

        System.out.println(words);

        List<Student> students = new ArrayList<>();
        
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Charli", 3.5));
        students.add(new Student("Sourabh", 4.2));
        students.add(new Student("Happy", 7.5));

        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName); // Java 8

        students.sort((o1, o2) -> {
            if ( o2.getGpa() - o1.getGpa() > 0)
                return 1;
            else if ( o2.getGpa() - o1.getGpa() < 0 )
                return -1;
            
            return 0;
        });

        students.sort(comparator);

        for( Student s: students) {
            System.out.println(s.getName() + " " + s.getGpa());
        }
    }
}
