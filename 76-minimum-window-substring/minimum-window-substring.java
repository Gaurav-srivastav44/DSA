class Solution {
    public String minWindow(String s, String t) {
        int n= s.length();
        int n2 = t.length();
        int[] freq = new int[128];
        for(char c : t.toCharArray()) freq[c]++;

        int i=0;
        int min = Integer.MAX_VALUE;
        String ans = "";

        for(int j=0; j<n; j++){
            if(freq[s.charAt(j)]-- > 0){
                n2--;
            }

            while(n2 == 0){
                if(j-i+1 < min){
                    min = j-i+1;
                    ans = s.substring(i, j + 1);
                }
                freq[s.charAt(i)]++;
                if(freq[s.charAt(i)] > 0){
                    n2++;
                }
                i++;
            }
        }

        return ans;
    }
}