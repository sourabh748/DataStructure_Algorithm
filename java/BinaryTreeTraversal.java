import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {
    static class TreeNode<E> {
        E data;
        TreeNode<E> left = null;
        TreeNode<E> right = null;

        public TreeNode(E data){
            this.data = data;
        }
    }

    public static List<Integer> inOrderTraversal(TreeNode<Integer> root){
        if (root == null)
            return List.of();

        List<Integer> result = new ArrayList<>();
        result.addAll(inOrderTraversal(root.left));
        result.add(root.data);
        result.addAll(inOrderTraversal(root.right));
        
        return result;
    }

    public static List<Integer> preOrderTraversal(TreeNode<Integer> root){
        if (root == null)
            return List.of();

        List<Integer> result = new ArrayList<>();
        result.add(root.data);
        result.addAll(preOrderTraversal(root.left));
        result.addAll(preOrderTraversal(root.right));

        return result;
    }
}
