class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j]=-1;
            }
        }
        return helper(obstacleGrid, 0, 0, dp);
    }
    public int helper(int[][] grid, int i, int j, int[][] dp){
        int m=grid.length;
        int n=grid[0].length;
        
        if(i>=m || j>=n || grid[i][j] == 1)return 0;
        if(i==m-1 && j==n-1)return 1;
        if(dp[i][j] != -1)return dp[i][j];

        return dp[i][j] = (helper(grid,i+1,j, dp) + helper(grid,i,j+1, dp));

    }
}