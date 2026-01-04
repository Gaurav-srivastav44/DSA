class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n==0 || s.charAt(0) == '0')return 0;
        int[] dp = new int[n+1];

        dp[0]=1;
        dp[1]=1;

        for(int i=2; i<=n; i++){
            int c1 = s.charAt(i-1) - '0';
            int c2 = s.charAt(i-2) - '0';

            if(c1 != 0){
                dp[i] += dp[i-1];
            }
            int k = c2 *10 +c1;
            if(k>=10 && k<=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];


    }
}