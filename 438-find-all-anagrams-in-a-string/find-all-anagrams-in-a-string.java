class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int l1 = s.length();
        int l2 = p.length();
        if(l1 < l2)return ans;

        char[] prr = p.toCharArray();
        Arrays.sort(prr);


        for(int i=0; i<=l1-l2; i++){
            String sub = s.substring(i, i+l2);
            char[] srr = sub.toCharArray();
            Arrays.sort(srr);
            
            if(Arrays.equals(prr, srr)){
                ans.add(i);
            }
        }
        return ans;

    }
}