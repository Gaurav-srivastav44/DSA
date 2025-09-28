class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m= grid.length, n= grid[0].length;

        if (k == 0) {
            List<List<Integer>> ans= new ArrayList<>();
            for (int i=0; i< m; i++) {
                List<Integer> row= new ArrayList<>();
                for (int j=0; j< n; j++)
                    row.add(grid[i][j]);
                ans.add(row);
            }
            return ans;
        }

        List<List<Integer>> ans= null;
        for (int i=0; i< k; i++) {
            ans= helper(grid);
            for (int r=0; r< m; r++)
                for (int c=0; c< n; c++)
                    grid[r][c]= ans.get(r).get(c);
        }
        return ans;
    }

    public List<List<Integer>> helper(int[][] grid) {
        int m= grid.length, n= grid[0].length, total= m * n;
        int[] arr= new int[total];
        int c=0;
        for (int i=0; i< m; i++)
            for (int j=0; j< n; j++)
                arr[c++]= grid[i][j];

        int temp= arr[total-1];
        int[] shifted= new int[total];
        shifted[0]= temp;
        for (int i=1; i< total; i++)
            shifted[i]= arr[i-1];

        List<List<Integer>> ans= new ArrayList<>();
        for (int i=0; i< m; i++) {
            List<Integer> row= new ArrayList<>();
            for (int j=0; j< n; j++)
                row.add(shifted[i*n+j]);
            ans.add(row);
        }
        return ans;
    }
}
