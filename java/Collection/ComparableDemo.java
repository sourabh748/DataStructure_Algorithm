package Collection;

import java.util.ArrayList;
import java.util.List;

import Collection.ListGeneric.Student;

public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        
        students.add(new Student("Alice", 3.5));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Charli", 3.5));
        students.add(new Student("Sourabh", 4.2));
        students.add(new Student("Happy", 7.5));

        students.sort(null);

        System.out.println(students);
    }
}
