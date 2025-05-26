package Collection.ListGeneric;

import java.util.Stack;
import java.util.Vector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;


class Person {
    
    private String name;
    private int age;

    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    
}

public class VectorGenerics {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>(5, 7);
        vector.add(17);

        System.out.println(vector);

        Stack<Integer> stack = new Stack<>();

        stack.add(10);
        Integer pop = stack.pop();
        System.out.println(
            pop
        );

        Map<Integer, String> mp = new HashMap<>();

        mp.put(1, "Sourabh Suman");
        mp.put(2, "Gourav Kumar");
        mp.put(3, "Khushi Bharti");

        for( Map.Entry<Integer, String> entries : mp.entrySet() ) {

            System.out.println(entries.getKey() +  " " + entries.getValue());
            entries.setValue(entries.getValue().toUpperCase());
        }

        System.out.println(mp);



        List<String> str = new CopyOnWriteArrayList<>();

        Thread readerThread = new Thread(() -> {
            try {
                int i = 0;
                while (true) {
                    i++;

                    for (String item : str) {
                        System.out.println("Reading Items:" + item);
                        Thread.sleep(1000);
                    }

                    if ( i == 20 )
                        break;
                }
            } catch ( Exception e) {
                System.out.println("Exception in reader Thread" + e);
            }
        });

        Thread writerThread = new Thread(() -> {
            try{
                for( int i= 0; i < 10; i++) {
                    Thread.sleep(500);
                    str.add("item" + i);
                }
            } catch( Exception e ) {
                System.out.println("Exception in Writter Thread" + e);
            }
        });

        readerThread.start();
        writerThread.start();
    }
}
