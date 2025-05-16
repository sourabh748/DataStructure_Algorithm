package dsa;

public class LinkedListM<T> {
    private Node<T> head;
    private int count = 0;

    public LinkedListM(){
        this.head = null;
    }

    public void addFont(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = this.head;
        this.head = newNode;
        this.count += 1;
    }

    public void print() {
        Node<T> curr = this.head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
