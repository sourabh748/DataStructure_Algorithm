import java.util.List;

public class BinarySeachTree {
    static class Node {
        int data;
        Node left = null;
        Node right = null;

        public Node(int data){
            this.data = data;
        }
    }

    public static Node insertNode(Node head, int data){ // Time complexity O(N)
        if (head == null){
            return new Node(data);
        }

        if (head.data < data){
            head.right = insertNode(head.right, data);
        } else {
            head.left = insertNode(head.left, data);
        }
        return head;
    }

    public static void printLeafNode(Node head){
        if (head == null)
            return;
        if (head.left == null && head.right == null){
            System.out.print(head.data + " ");
        }
        printLeafNode(head.left);
        printLeafNode(head.right);
    }
    
    public static void printTree(Node root) {
        printTree(root, 0);
    }

    private static void printTree(Node node, int level) {
        if (node == null) return;

        printTree(node.right, level + 1);

        System.out.println("    ".repeat(level) + node.data);

        printTree(node.left, level + 1);
    }



    public static void main(String[] args){
        List<Integer> dataIntegers = 
                        List.of(30, 100, 80, 50, 90, 60, 90, 85, 95, 120, 110, 108, 115, 140, 150);

        Node root = null;
        for(Integer node : dataIntegers){
            root = insertNode(root, node);
        }
        printLeafNode(root);
    }
}