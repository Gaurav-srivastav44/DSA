class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int ans = 1;

        for (String w : words) {
            int best = 1;
            for (int i=0; i<w.length(); i++) {
                String str = w.substring(0, i) + w.substring(i + 1);
                
                best = Math.max(best, dp.getOrDefault(str, 0) + 1);
            }
            dp.put(w, best);
            ans = Math.max(ans, best);
        }
        return ans;
    }
}
