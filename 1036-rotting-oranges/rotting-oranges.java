class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] time = new int[m][n];

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                time[i][j] = Integer.MAX_VALUE;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    dfs(grid, time, i, j, 0);
                }
            }
        }

        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    if(time[i][j] == Integer.MAX_VALUE)
                        return -1;
                    ans = Math.max(ans, time[i][j]);
                }
            }
        }
        return ans;
    }

    void dfs(int[][] grid, int[][] time, int i, int j, int t){
        int m = grid.length, n = grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n) return;
        if(grid[i][j] == 0) return;
        if(t >= time[i][j]) return;

        time[i][j] = t;

        dfs(grid, time, i+1, j, t+1);
        dfs(grid, time, i-1, j, t+1);
        dfs(grid, time, i, j+1, t+1);
        dfs(grid, time, i, j-1, t+1);
    }
}
