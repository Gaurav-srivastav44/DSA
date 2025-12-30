class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        q.add(new int[]{0,0,1});
        vis[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];

            if(x==n-1 && y==n-1) return d;
            for(int[] k : dir){
                int nx = x + k[0];
                int ny = y + k[1];

                if(nx>=0 && ny>=0 && nx<n && ny<n 
                   && grid[nx][ny]==0 && !vis[nx][ny]){
                    vis[nx][ny] = true;
                    q.add(new int[]{nx, ny, d+1});
                }
            }
        }
        return -1;
    }
}
