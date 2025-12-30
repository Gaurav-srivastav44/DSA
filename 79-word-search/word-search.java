class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dfs(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int idx, int i, int j){
        if(idx == word.length())return true;
        if(i<0 || j<0 ||i>=board.length || j>=board[0].length)return false;

        if(board[i][j] != word.charAt(idx))return false;

        char temp = board[i][j];
        board[i][j]='#';

        boolean found = (dfs(board,word,idx+1,i+1,j) ||
                dfs(board,word,idx+1,i-1,j) ||
                dfs(board,word,idx+1,i,j+1) ||
                dfs(board,word,idx+1,i,j-1));

        board[i][j] = temp;
        return found;
    }
}