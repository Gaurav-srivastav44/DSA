class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination)return true;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        vis[source] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i: adj.get(curr)){
                if(!vis[i]){    
                    if(i == destination)return true;
                    q.add(i);
                    vis[i] = true;
                }
            }
        }
        return false;

    }
}