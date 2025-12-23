class Solution {
    public int numWays(String s) {
        long mod = 1000000007;
        int n = s.length();

        int ones = 0;
        for(char c : s.toCharArray())
            if(c == '1') ones++;

        if(ones == 0){
            long x = n - 1;
            return (int)((x * (x - 1) / 2) % mod);
        }

        if(ones % 3 != 0) return 0;

        int k = ones / 3;
        int[] pos = new int[ones];
        int j = 0;

        for(int i = 0; i < n; i++)
            if(s.charAt(i) == '1') pos[j++] = i;

        long gap1 = pos[k] - pos[k-1];
        long gap2 = pos[2*k] - pos[2*k-1];

        return (int)((gap1 * gap2) % mod);
    }
}
