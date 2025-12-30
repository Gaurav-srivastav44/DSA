class Solution {
    public int findCircleNum(int[][] g) {
        int n = g.length;
        int[] parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(g[i][j] == 1)
                    union(i, j, parent);
            }
        }

        int count = 0;
        for(int i=0; i<n; i++)
            if(parent[i] == i) count++;

        return count;
    }

    int find(int x, int[] parent){
        if(parent[x] != x)
            parent[x] = find(parent[x], parent);
        return parent[x];
    }

    void union(int a, int b, int[] parent){
        int pa = find(a, parent);
        int pb = find(b, parent);
        if(pa != pb) parent[pb] = pa;
    }
}
