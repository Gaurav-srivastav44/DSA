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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //agar koi value hi nahi hai to target sum ke barabar kanbhi nahi hoga
        if(root ==  null)return false;

        //agar ek hi element hai (left or right nahi hai) to check karenge ki uski value target ke barabar hai to true nahi to false
        if(root.left == null && root.right == null){
            if(targetSum == root.val)return true;
            else return false;
        }

        //fir recursive call karenge left  or right ke liye leafnode tak jaenge  agar sum possibble hai to true
        return hasPathSum(root.left, targetSum-root.val)
                ||
                hasPathSum(root.right, targetSum-root.val);
    }
}