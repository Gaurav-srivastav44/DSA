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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(root, targetSum, list, curr, 0);
        return list;
    }

    public void helper(TreeNode root, int target, List<List<Integer>> list, List<Integer> curr, int csum){
        if(root == null)return ;

        csum += root.val;
        curr.add(root.val);

        if(root.left == null && root.right == null){
            if(csum == target){
                list.add(new ArrayList<>(curr));
            }
        }

        helper(root.left, target, list, curr, csum);
        helper(root.right, target, list, curr, csum);
        curr.remove(curr.size()-1);
    }
}












