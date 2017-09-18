import sun.reflect.generics.tree.Tree;

/**
 * Created by Tang on 2017/9/18.
 */
public class MaximumDepthofBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        int maxDepth=0;
        if(root==null) return maxDepth;
        return depth(root,maxDepth);
    }
    public int depth(TreeNode root,int depth){
        if(root==null) return depth;
        if(root.left!=null||root.right!=null)
            return Math.max(depth(root.left,depth+1),depth(root.right,depth+1));
        else return depth+1;
    }
    public static void main(String[] args){
        TreeNode root,h;
        root=h=new TreeNode(3);
        h.left=new TreeNode(9);
        h.right=new TreeNode(20);
        h=root.right;
        h.left=new TreeNode(15);
        h.right=new TreeNode(7);
        System.out.print(new MaximumDepthofBinaryTree().maxDepth(root));
    }
}
