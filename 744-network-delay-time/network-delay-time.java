class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<int[]>());
        }
        for(int[] i : times){
            int u = i[0];
            int v = i[1];
            int wt = i[2];
            adj.get(u).add(new int[]{v,wt});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            for(int[] nbr : adj.get(u)){
                int v = nbr[0];
                int wt = nbr[1];

                if(dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        int ans =0;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans , dist[i]);
        }
        return ans;

    }
}