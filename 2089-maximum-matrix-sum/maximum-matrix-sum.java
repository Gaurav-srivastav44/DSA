class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int c=0;
        long sum=0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                sum += Math.abs(matrix[i][j]);
                min = Math.min(min, Math.abs(matrix[i][j]));
                if(matrix[i][j] <= 0){
                    c++;
                }
            }
        }
        if(c%2 == 0)return sum;

        sum -= 2*min;

        return sum;



    }
}