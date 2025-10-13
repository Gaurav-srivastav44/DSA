class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int j=0; j<n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i=1; i<n; i++) {
            for (int j=0; j<n; j++) {

                int left = 0;
                if(j>0){
                    left = dp[i-1][j-1];
                }
                else{
                    left = Integer.MAX_VALUE;
                }


                int up = dp[i-1][j];


                int right =0;
                if(j<n-1){
                    right = dp[i-1][j+1];
                }
                else{
                    right = Integer.MAX_VALUE;
                }


                dp[i][j] = matrix[i][j] + Math.min(left, Math.min(up, right));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j=0; j<n; j++) {
            min= Math.min(min, dp[n - 1][j]);
        }
        return min;
    }
}
