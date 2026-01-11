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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDepth = depth(root);
        return solve(root, 1, maxDepth);
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

    private TreeNode solve(TreeNode node, int level, int maxDepth) {
        if (node == null) return null;
        if (level == maxDepth) return node;

        TreeNode L = solve(node.left, level + 1, maxDepth);
        TreeNode R = solve(node.right, level + 1, maxDepth);

        if (L != null && R != null) return node;
        return L != null ? L : R;
    }
}
