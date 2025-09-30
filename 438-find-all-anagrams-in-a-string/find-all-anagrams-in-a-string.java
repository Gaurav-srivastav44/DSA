class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] freqP = new int[26];
        int[] freqS = new int[26];

        for (char c : p.toCharArray()){
            freqP[c-'a']++;
        }
        int w = p.length();

        for (int i=0; i<s.length(); i++) {
            freqS[s.charAt(i)-'a']++;
            if (i >= w){
                freqS[s.charAt(i-w)-'a']--;
            }
            if (Arrays.equals(freqS, freqP)){
                res.add(i-w+1);
            }
        }
        return res;
    }
}
