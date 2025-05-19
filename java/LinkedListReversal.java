public class LinkedListReversal {
    static class Node {
        public int data;
        public Node next = null;

        public Node(int data){
            this.data = data;
        }
    }

    public static void printLinkedList(Node head){
        Node curr = head;

        while (curr != null){
            System.out.print(curr.data + (curr.next != null ? "->": ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static Node mergeTwoSortedLinkedList(Node head1, Node head2){

        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        if (head1.data < head2.data){
            head1.next = mergeTwoSortedLinkedList(head1.next, head2);
            return head1;
        }
        head2.next = mergeTwoSortedLinkedList(head1, head2.next);
        return head2;
    }
    

    public static Node reverseLinkedList(Node head){
        if (head == null || head.next == null)
            return head;
        Node newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }
    public static void main(String[] args) {

        // Sorted LinkedList 1
        Node n0 = new Node(0);
        Node n1 = new Node(5);
        Node n2 = new Node(7);
        Node n3 = new Node(10);
        Node n4 = new Node(15);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        // Sorted LinkedList 2
        Node n5 = new Node(1);
        Node n6 = new Node(3);
        Node n7 = new Node(7);
        Node n8 = new Node(10);

        n5.next = n6;
        n6.next = n7;
        n7.next = n8;


        printLinkedList(n0);
        printLinkedList(n5);

        // Node newHead = reverseLinkedList(n0);
        // printLinkedList(newHead);

        Node newMergedHead = mergeTwoSortedLinkedList(n0, n5);
        printLinkedList(newMergedHead);
    }
}
