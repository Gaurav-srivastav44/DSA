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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode build(int[] arr, int min, int max){
        if(i >= arr.length)return null;

        if(arr[i]<min || arr[i]>max)return null;

        TreeNode root = new TreeNode(arr[i++]);
        root.left = build(arr, min, root.val);
        root.right = build(arr, root.val, max);

        return root;
    }
}