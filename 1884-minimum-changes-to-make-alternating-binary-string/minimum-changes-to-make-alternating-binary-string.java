class Solution {
    public int minOperations(String s) {
        int n = s.length();
        String s1 = "";
        String s2 = "";
        for(int i=0; i<n; i++){
            if(i%2 == 0){
                s1 += "1";
                s2 += "0";
            }
            else {
                s1 += "0";
                s2 += "1";
            }
        }

        int c1=0, c2=0;

        for(int i=0; i<n; i++){
            if(s.charAt(i) != s1.charAt(i))c1++;
            if(s.charAt(i) != s2.charAt(i))c2++;
        }

        int ans = Math.min(c1, c2);
        return ans;
    }
}