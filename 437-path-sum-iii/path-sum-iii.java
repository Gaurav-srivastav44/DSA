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
    public int pathSum(TreeNode root, int t) {
        if(root == null) return 0;

        return count(root,t)+ pathSum(root.left,t)+ pathSum(root.right,t);
    }

    private int count(TreeNode node, long sum){
        if(node == null) return 0;

        int c = 0;
        if(node.val == sum) c++;

        long newS= sum-node.val;
        c += count(node.left, newS);
        c += count(node.right, newS);

        return c;
    }
}