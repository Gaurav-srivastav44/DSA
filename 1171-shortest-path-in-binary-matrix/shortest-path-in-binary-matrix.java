class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0]==1 || grid[n-1][n-1]==1) return -1;


        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        
        //in queue we store row, column and distance
        q.add(new int[]{0,0,1});
        vis[0][0] = true;

        int[][] moves = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        while(!q.isEmpty()){
            //for all 8 direction 
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];

            if(x==n-1 && y==n-1) return d;
            for(int[] m : moves){
                //make new x and y
                int nx=x+m[0];
                int ny=y+m[1];

                //check if valid
                if(nx>=0 && ny>=0 && nx<n && ny<n && grid[nx][ny]==0 && !vis[nx][ny]){
                    vis[nx][ny] = true;
                    q.add(new int[]{nx, ny, d+1});
                }
            }
        }
        return -1;
    }
}
