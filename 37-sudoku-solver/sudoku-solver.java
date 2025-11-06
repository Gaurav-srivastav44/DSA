class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    for(char c='1'; c<='9'; c++){
                        if(check(board,i,j,c)){
                            board[i][j] = c;
                            if(solve(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return  false;
                }
            }
        }
        return true;
    }

    public boolean check(char[][] board, int row, int col, char c){
        for(int i=0; i<9; i++){
            if(board[row][i] == c || board[i][col] == c){
                return false;
            }
            int boxr= 3*(row/3) + i/3;
            int boxc= 3*(col/3) + i%3;
            if(board[boxr][boxc] == c){
                return false;
            }
        }
        return true;
    }
}