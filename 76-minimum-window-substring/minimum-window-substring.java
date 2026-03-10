class Solution {
    public String minWindow(String s, String t) {

        int n = s.length();
        int min = Integer.MAX_VALUE;
        String ans = "";

        int i=0;
        int[] freq = new int[128];
        for(char c : t.toCharArray()) freq[c]++;

        int count = t.length();

        for(int j=i; j<n; j++){
            if(freq[s.charAt(j)] > 0){
                count--;
            }
            freq[s.charAt(j)]--;

            while(count==0){
                if(j-i+1 < min){
                    min = j-i+1;
                    ans = s.substring(i,j+1);
                }
                freq[s.charAt(i)]++;
                if(freq[s.charAt(i)] > 0) count++;
                i++;
            }
        }
        return ans;
    }
}