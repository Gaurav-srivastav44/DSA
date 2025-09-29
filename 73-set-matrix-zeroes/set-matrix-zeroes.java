class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int i :row){
            for(int j=0;j<n;j++){
                matrix[i][j] = 0;
            }
        }

        for(int i=0;i<m;i++){
            for(int j : col){
                matrix[i][j] = 0;
            }
        }

    }
}