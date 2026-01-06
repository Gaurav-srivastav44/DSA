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
    public int maxLevelSum(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        bfs(root, list);

        int ans = 1;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<list.size(); i++){
            int sum =0;
            for(int j=0; j<list.get(i).size(); j++){
                sum += list.get(i).get(j);
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println("");
            if(sum > max){
                max = sum;
                ans = i+1;
            }
        }
        return ans;

    }


    public ArrayList<ArrayList<Integer>> bfs(TreeNode root, ArrayList<ArrayList<Integer>> list){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            ArrayList<Integer> l = new ArrayList<>();
            int n =q.size();
            for(int i=0; i<n; i++){
                TreeNode t = q.poll();
                l.add(t.val);

                if(t.left != null)q.add(t.left);
                if(t.right != null)q.add(t.right);
            }
            list.add(l);
        }

        return list;


    }
}