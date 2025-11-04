class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // if(m==0){
        //     return n;
        // }
        int[] dp = new int[n+1];
        for(int i=0;i<n+1;i++){
            dp[i]=i;
        }
        for(int i=1;i<=m;i++){
            int[] temp = new int[n+1];
            temp[0]=i;
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    temp[j]=dp[j-1];
                }
                else{
                    int min=Math.min(temp[j-1],dp[j]);
                    temp[j]=Math.min(min,dp[j-1])+1;
                }
            }
            dp = temp;
        } 
        return dp[n];
    }
}