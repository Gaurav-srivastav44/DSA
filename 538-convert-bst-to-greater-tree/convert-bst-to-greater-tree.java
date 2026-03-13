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
    public TreeNode convertBST(TreeNode root) {
        if(root == null)return null;
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        Collections.sort(list);

        int n = list.size();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)arr[i] = list.get(i);

        int[] suff = new int[n];
        suff[n-1]=arr[n-1];
        for(int i=n-2; i>=0; i--){
            suff[i] = suff[i+1] + arr[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i], suff[i]);
        }
        
        return update(root, map);
    }

    public TreeNode update(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null)return root;
        update(root.left, map);
        root.val = map.get(root.val);
        update(root.right, map);
        return root;
    }

    public void inorder(TreeNode root, ArrayList<Integer> list){
        if(root==null)return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}