class Solution {
    public int maxEnvelopes(int[][] env) {
        Arrays.sort(env, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] dp = new int[env.length];
        int len = 0;

        for (int[] e : env) {
            int h = e[1];
            int idx = Arrays.binarySearch(dp, 0, len, h);
            if (idx < 0) idx = -(idx + 1);
            dp[idx] = h;
            if (idx == len) len++;
        }
        return len;
    }
}
