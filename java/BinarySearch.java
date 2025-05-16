import position.Position;


public class BinarySearch {  // Time Complexity of O(log(N)) base 2, Space Complexity O(1)

    public static void main(String[] args) {
        // int card[] = {6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 2, 1};
        int card2[] = {2, 3, 4, 5, 6, 9, 0};
        
        Position p = new Position();
        p.cards = card2;
        
        System.out.println(p.countRotation());
    }
}