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
    public int maxProduct(TreeNode root) {
        long total = bsum(root);
        long[] ans = new long[1];
        dfs(root, total, ans);
        return (int)(ans[0] % 1000000007);
    }
    public int bsum(TreeNode root){
        if(root == null) return 0;
        return root.val
               + bsum(root.left)
               + bsum(root.right);
        
    }
    public long dfs(TreeNode root, long total, long[] max) {
        if (root == null) return 0;

        long curr = root.val + dfs(root.left, total, max) + dfs(root.right, total, max);
        max[0] = Math.max(max[0], curr * (total - curr));
        return curr;
    }
}