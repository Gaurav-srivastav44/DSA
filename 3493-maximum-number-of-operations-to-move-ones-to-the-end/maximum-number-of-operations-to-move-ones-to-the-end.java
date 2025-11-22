class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        String r = new StringBuilder(s).reverse().toString();
        

        int start=n;
        for(int i=0; i<n; i++){
            if(r.charAt(i) == '0'){
                start=i;
                break;
            }
        }

        int impact =1;
        int ans =0; 
        int j=-1;
        for(int i=start; i<n; i++){
            if(r.charAt(i) == '0')continue;
            
            int cnt  =0;
            for(j=i; j<n; j++){
                if(r.charAt(j) == '0')break;
                cnt++;
            }
            ans += cnt * impact;
            impact++;
            i = j-1; 
        }
        return ans;
    }
}