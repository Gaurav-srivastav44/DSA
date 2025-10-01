class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
        int m=s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int i=0;
        int j=0;
        int c=0;

        while(i<n && j<m){
            if(s[j] >= g[i]){
                c++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return c;
    }
}