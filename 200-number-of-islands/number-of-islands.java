class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int islands = 0;

        boolean[][] vis = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j]){
                    if(grid[i][j] == '1'){
                        dfs(grid, i, j, vis);
                        islands++;
                    }
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int i,int j, boolean[][] vis){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n)return;
        if(vis[i][j] || grid[i][j] == '0')return;

        vis[i][j] = true; 

        dfs(grid, i+1, j, vis);
        dfs(grid, i, j+1, vis);
        dfs(grid, i-1, j, vis);
        dfs(grid, i, j-1, vis);
    }
}