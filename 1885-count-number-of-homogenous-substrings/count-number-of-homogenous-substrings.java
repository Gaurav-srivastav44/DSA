class Solution {
    public int countHomogenous(String s) {
        int n = s.length();
        int ans=0, c=0;
        for(int i=0; i<n; i++){
            if(i>0 && s.charAt(i)==s.charAt(i-1)){
                c++;
            }
            else c=1;
            ans = (ans+c) % 1000000007;
        }
        return ans;
    }
}