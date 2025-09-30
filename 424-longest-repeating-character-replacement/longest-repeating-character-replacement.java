class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left=0;
        int max=0;
        int res=0;

        for (int i=0; i<s.length(); i++) {
            count[s.charAt(i) - 'A']++;
            max = Math.max(max, count[s.charAt(i) - 'A']);

            while (i-left+1-max > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, i-left+1);
        }
        return res;
    }
}
