package dsa;

public class Node<E> {
    public E data;
    public Node<E> next;

    Node(E item) {
        this.data = item;
        this.next = null;
    }
}
