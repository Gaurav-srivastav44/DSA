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
    public boolean isEvenOddTree(TreeNode root) {
        int lvl = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode prev = null;

        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                TreeNode curr = q.poll();
                if(lvl%2 == 0){
                    if(curr.val%2 ==0)return false;
                    if(i!=0 && curr.val <= prev.val)return false;
                }
                else{
                    if(curr.val%2 != 0)return false;
                    if(i!=0 && curr.val >= prev.val)return false;
                }
                prev = curr;

                if(curr.left != null)q.add(curr.left);
                if(curr.right != null)q.add(curr.right);
            }
            lvl++;
        }
        return true;
    }
}