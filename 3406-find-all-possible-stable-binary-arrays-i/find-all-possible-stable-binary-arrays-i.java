class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {

        int mod = 1000000007;

        long[][] end0 = new long[zero+1][one+1];
        long[][] end1 = new long[zero+1][one+1];

        for(int i=1;i<=Math.min(limit,zero);i++) end0[i][0]=1;
        for(int j=1;j<=Math.min(limit,one);j++) end1[0][j]=1;

        for(int i=1;i<=zero;i++){
            for(int j=1;j<=one;j++){

                for(int k=1;k<=limit && i-k>=0;k++)
                    end0[i][j]=(end0[i][j]+end1[i-k][j])%mod;

                for(int k=1;k<=limit && j-k>=0;k++)
                    end1[i][j]=(end1[i][j]+end0[i][j-k])%mod;
            }
        }

        return (int)((end0[zero][one] + end1[zero][one]) % mod);
    }
}