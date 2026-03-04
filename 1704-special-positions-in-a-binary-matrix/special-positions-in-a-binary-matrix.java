class Solution {
    public int numSpecial(int[][] mat) {
        int ans=0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1 && check(mat, i, j)){
                    ans += 1;
                }
            }
        }
        return ans;
    }
    public boolean check(int[][] mat, int r, int c){
        int cnt=0;
        for(int i=0; i<mat.length; i++){
            if(mat[i][c] == 1)cnt++;
        }
        for(int i=0; i<mat[0].length; i++){
            if(mat[r][i] == 1)cnt++;
        }
        if(cnt==2)return true;
        return false;
    }
}