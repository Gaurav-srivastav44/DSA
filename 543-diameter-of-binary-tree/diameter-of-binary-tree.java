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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        max[0]=0;
        dia(root,max);
        return max[0];
    }
    public int dia(TreeNode root, int[] max){
        if(root == null)return 0;
        
        int lh = dia(root.left, max);
        int rh = dia(root.right, max);

        int curr = lh +rh;

        max[0] = Math.max(max[0],curr);

        return 1+Math.max(lh,rh);
    }
}