import sun.reflect.generics.tree.Tree;

import javax.xml.stream.FactoryConfigurationError;

/**
 * Created by Tang on 2017/9/17.
 */
public class ValidateBinarySearchTree {

     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
      }

    public boolean isValidBST(TreeNode root) {
         return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean isBST(TreeNode root,long minValue,long maxValue) {
        if(root==null) return true;
        if (minValue < root.val && root.val < maxValue)
            return isBST(root.left,minValue,root.val)&&
                    isBST(root.right,root.val,maxValue);
        else return false;
    }
    public static void main(String[] args){

        TreeNode root,h;
        root=h=new TreeNode(-2147483648);
        h.right=new TreeNode(2147483647);
//        h.left=new TreeNode(5);
//        h.right=new TreeNode(15);
//        h=h.right;
//        h.left=new TreeNode(6);
//        h.right=new TreeNode(20);
        System.out.print(new ValidateBinarySearchTree().isValidBST(root));
    }
}
