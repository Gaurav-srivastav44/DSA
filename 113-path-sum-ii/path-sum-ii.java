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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null)return ans;
        List<Integer> curr = new ArrayList<>();
        dfs(root, curr, targetSum);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> curr, int target){
        if(root==null)return;
        curr.add(root.val);
        
        if(root.left==null && root.right==null && root.val==target){
            ans.add(new ArrayList<>(curr));
        }


        dfs(root.left, curr, target-root.val);
        dfs(root.right, curr, target-root.val);

        curr.remove(curr.size()-1);
    }
}