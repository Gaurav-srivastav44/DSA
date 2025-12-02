class Solution {
    static final long MOD = 1_000_000_007;

    long nC2(long n) {
        if (n < 2) return 0;
        return (n * (n - 1) / 2) % MOD;
    }

    public int countTrapezoids(int[][] points) {
        Map<Integer, Long> map = new HashMap<>();
        for (int[] p : points) map.put(p[1], map.getOrDefault(p[1], 0L) + 1);

        long sum = 0, sumSq = 0;
        for (long c : map.values()) {
            long w = nC2(c);
            sum = (sum + w) % MOD;
            sumSq = (sumSq + (w * w) % MOD) % MOD;
        }

        long ans = (sum * sum % MOD - sumSq + MOD) % MOD;
        ans = ans * ((MOD + 1) / 2) % MOD;
        return (int) ans;
    }
}
