class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] b = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(b[i],'.');
        }
        helper(b, ans, 0, n);
        return ans;
    }
    public void helper(char[][] b, List<List<String>> ans, int col, int n){
        if(col == n){
            ans.add(sol(b));
            return;
        }
        for(int i=0 ; i<n; i++){
            if(valid(i,col,b)){
                b[i][col] ='Q';
                helper(b, ans, col+1, n);
                b[i][col] = '.';
            }
        }
    }

    public boolean valid(int row, int col, char[][] b){
        int r=row, c=col;
        int n=b.length;
        while(r>=0 && c>=0){
            if(b[r][c] == 'Q')return false;
            r--;c--;
        }

        r=row; c=col;
        while(c>=0){
            if(b[r][c] == 'Q')return false;
            c--;
        }
        r=row; c=col;
        
        while(r<n && c>=0){
            if(b[r][c] == 'Q')return false;
            r++;c--;
        }
        return true;
    }
    public List<String> sol(char[][] b){
        int n= b.length;
        List<String> ans = new ArrayList<>();
        for(int i=0; i<n ;i++){
            ans.add(new String(b[i]));
        }
        return ans;
    }
}