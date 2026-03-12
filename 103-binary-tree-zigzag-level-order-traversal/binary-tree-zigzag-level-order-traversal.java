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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean LtoR = false;

        while(!q.isEmpty()){
            int n = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0; i<n; i++){
                TreeNode curr = q.poll();
                
                if(LtoR)list.addFirst(curr.val);
                else list.addLast(curr.val);
                
                if(curr.left != null)q.add(curr.left);
                if(curr.right != null)q.add(curr.right);
            }
            LtoR = !LtoR;
            ans.add(list);
        }
        return ans;
    }
}