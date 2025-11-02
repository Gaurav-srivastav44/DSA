class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid=new int[m][n];
        for(int[] g:guards){
            grid[g[0]][g[1]]=1;
        }
        for(int[] w:walls){
            grid[w[0]][w[1]]=2;
        }
        boolean[][] seen=new boolean[m][n];
        
        int[][] d={{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] g:guards){
            for(int[] x:d){
                int r=g[0],c=g[1];
                while(true){
                    r+=x[0];c+=x[1];
                    if(r<0||c<0||r>=m||c>=n)break;
                    if(grid[r][c]==1||grid[r][c]==2)break;
                    seen[r][c]=true;
                }
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0&&!seen[i][j])ans++;
            }
        }
        return ans;
    }
}
