package Collection.ListGeneric;

import java.util.LinkedList;
import java.util.List;

public class LinkedListGeneric {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(); // Doubly Linked List

        list.addAll(List.of(1, 2, 5, 15 ,7, 10));
        list.addFirst(176);

        System.out.println(list.getFirst());

    }
}
