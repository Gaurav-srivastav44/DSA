class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

    int l1=matrix.length;
    int l2=matrix[0].length;
    for(int i=0;i<l1;i++){
        for(int j=0;j<l2;j++){
            if(matrix[i][j] == target){
                return true;
            }
        }
    }
    return false;
        
    }
}