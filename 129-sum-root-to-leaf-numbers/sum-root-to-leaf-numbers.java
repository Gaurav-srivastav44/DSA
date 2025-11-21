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
    int ans;
    public int sumNumbers(TreeNode root) {
        ans =0;
        sum(root, 0);
        return ans;
    }
    public void sum(TreeNode root,int sum){
        if(root == null)return;
        sum= sum*10 + root.val;
        if(root.left == null && root.right == null){
            ans += sum;
            return;
        }

        sum(root.left,sum);
        sum(root.right,sum);
        
    }
}