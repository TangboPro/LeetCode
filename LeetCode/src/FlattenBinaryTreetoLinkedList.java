import com.sun.deploy.ref.Helpers;

/**
 * Created by Tang on 2017/9/18.
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/
 */
public class FlattenBinaryTreetoLinkedList {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args){
        TreeNode root,h;
        root=h=new TreeNode(3);
        h.left=new TreeNode(9);
        h.right=new TreeNode(20);
        h=root.right;
        h.left=new TreeNode(15);
        h.right=new TreeNode(7);
        new FlattenBinaryTreetoLinkedList().flatten(root);
    }
}
