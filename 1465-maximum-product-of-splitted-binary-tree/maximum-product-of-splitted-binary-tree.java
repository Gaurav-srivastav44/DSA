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
        int total = bsum(root);
        long ans[] = new long[1];

        dfs(root, total, ans);
        return (int)(ans[0] % 1000000007);

    }
    public int bsum(TreeNode root){
        if(root == null)return 0;
        return root.val + bsum(root.left) + bsum(root.right);
    }

    public long dfs(TreeNode root, int total, long[] ans){
        if(root == null)return 0;

        long left = dfs(root.left, total, ans);
        long right = dfs(root.right, total, ans);
        long curr = root.val + left + right;

        ans[0] = Math.max(ans[0], curr *(total - curr)); 
        return curr;

    }
}