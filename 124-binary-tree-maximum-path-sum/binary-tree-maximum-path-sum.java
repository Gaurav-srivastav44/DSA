/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if(root == null)return 0;
        if(root.left==null && root.right==null)return root.val;

        int lsum = helper(root.left);
        int rsum = helper(root.right);
        int sum = root.val;

        sum = Math.max(sum, root.val+lsum );
        sum = Math.max(sum, root.val+rsum);
        sum = Math.max(sum, root.val+lsum+rsum);

        int lmax = Integer.MIN_VALUE; 
        if(root.left != null)lmax=maxPathSum(root.left);
        int rmax = Integer.MIN_VALUE; 
        if(root.right != null)rmax=maxPathSum(root.right);
        
        int max = Math.max(lmax, rmax);

        return Math.max(sum, max);

    }

    public int helper(TreeNode root){
        if(root == null)return 0;
        
        int sum = root.val;
        int l = Math.max(0,helper(root.left));
        int r = Math.max(0,helper(root.right));
        sum += Math.max(l,r);
        return sum;
    }
}