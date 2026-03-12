/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root || q==root)return root;

        boolean lp = contains(root.left, p);
        boolean lq = contains(root.left, q);
        boolean rq = contains(root.right, q);
        boolean rp = contains(root.right, p);

        if((lp && rq) || (lq && rp))return root;

        if(lp && lq)return lowestCommonAncestor(root.left, p, q);
        if(rp && rq)return lowestCommonAncestor(root.right, p, q);
        return root;
    }
    public boolean contains(TreeNode root, TreeNode x){
        if(root == null)return false;
        if(root == x)return true;

        return contains(root.left, x)|| contains(root.right, x);
    }
}