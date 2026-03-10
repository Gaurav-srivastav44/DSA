class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(original == color)return image;

        dfs(image, sr, sc, color, original);
        return image;
    }
    public void dfs(int[][] arr, int i, int j, int make, int original){
        int m = arr.length;
        int n = arr[0].length;

        if(i<0 || j<0 || i>=m || j>=n)return;
        if(arr[i][j] != original)return;

        arr[i][j] = make;

        dfs(arr, i+1, j, make, original);
        dfs(arr, i-1, j, make, original);
        dfs(arr, i, j+1, make, original);
        dfs(arr, i, j-1, make, original);

    }
}