class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination)return true;
        boolean[] vis = new boolean[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)adj.add(new ArrayList<>());
        for(int[] i : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        return(dfs(adj, source, destination, vis));

    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, int target, boolean[] vis){
        if(src == target)return true;
        vis[src] = true;
        for(int i : adj.get(src)){
            if(!vis[i]){
                if(dfs(adj, i, target, vis))return true;
            }
        }
        return false;
    }
}