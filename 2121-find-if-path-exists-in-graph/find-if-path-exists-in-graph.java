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
        Queue<Integer> q = new LinkedList<>();
        vis[source] = true;
        q.add(source);

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i : adj.get(curr)){
                if(!vis[i]){
                    if(i == destination)return true;
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        return false;
    }

    
}