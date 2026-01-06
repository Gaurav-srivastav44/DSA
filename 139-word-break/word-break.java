class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        Set<String> set = new HashSet<>(wordDict);

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (set.contains(s.substring(i, j + 1))) {
                    dp[i][j] = true;
                } else {
                    for (int k = i; k < j; k++) {
                        if (dp[i][k] && dp[k + 1][j]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
