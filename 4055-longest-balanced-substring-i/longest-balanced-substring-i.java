class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;
        
        for(int i=0;i<n;i++){
            int[] f = new int[26];
            int distinct = 0, maxFreq = 0;
            
            for(int j=i;j<n;j++){
                int idx = s.charAt(j) - 'a';
                if(f[idx] == 0) distinct++;
                f[idx]++;
                maxFreq = Math.max(maxFreq, f[idx]);
                
                int len = j - i + 1;
                if(len == distinct * maxFreq){
                    ans = Math.max(ans, len);
                }
            }
        }
        return ans;
    }
}
