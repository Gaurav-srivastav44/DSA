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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return root;

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }

        else{
            if(root.left == null)return root.right;
            if(root.right == null)return root.left;

            //right side me leftmost element hoga vo (kyoki minimum hoga or root ki value se jada hoga)
            TreeNode min = minimum(root.right);  
            
            //root ko vo minimum value dedo
            root.val = min.val;

            //right tree me se vo minimum element remove kar denge recursive call se
            root.right = deleteNode(root.right, min.val);
        }
        return root;
    }

    public TreeNode minimum(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}