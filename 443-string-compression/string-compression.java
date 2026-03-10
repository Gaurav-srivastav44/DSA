class Solution {
    public int compress(char[] chars) {
        int n= chars.length;
        StringBuilder sb = new StringBuilder();
        int i=0;

        while(i<n){
            char ch =chars[i];
            int c=0;
            while(i<n && chars[i] == ch){
                c++;
                i++;
            }

            sb.append(ch);
            if(c>1)sb.append(c);
        }
        String ans = sb.toString();
        int l = ans.length();

        for(int j=0; j<l; j++){
            chars[j] = ans.charAt(j);
        }
        return l;
    }
}