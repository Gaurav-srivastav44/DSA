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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return helper(nums, 0, n-1);
    }
    public TreeNode helper(int[] arr, int i, int j){
        if(i>j)return null;

        int m = i+(j-i)/2;
        TreeNode root = new TreeNode(arr[m]);
        root.left = helper(arr, i, m-1);
        root.right = helper(arr, m+1, j);
        return root;
    }
}