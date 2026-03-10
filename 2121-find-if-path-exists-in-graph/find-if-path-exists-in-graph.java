class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination)return true;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)adj.add(new ArrayList<>());
        for(int[] i : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        boolean[] vis = new boolean[n];
        return dfs(vis, adj, source, destination);
    }

    public boolean dfs(boolean[] vis, ArrayList<ArrayList<Integer>> adj, int src, int des){
        if(src == des)return true;
        vis[src] = true;

        for(int i : adj.get(src)){
            if(!vis[i] && dfs(vis, adj, i, des)){
                return true;
            }
        }
        return false;

    }
}