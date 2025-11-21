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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);

        while(!Q.isEmpty()){
            List<Integer> curr = new ArrayList<>();

            int size = Q.size();
            for(int i=0; i<size; i++){
                TreeNode n = Q.poll();
                curr.add(n.val);
                if(n.left != null){
                   Q.add(n.left);
                }
                if(n.right != null){
                   Q.add(n.right);
                }
            }
            ans.add(curr);
        }
        return ans;
        
    }
}