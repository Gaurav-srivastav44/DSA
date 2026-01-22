class Solution {
    public int largestVariance(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char i : s.toCharArray()){
            map.put(i, map.getOrDefault(i,0) +1);
        }
        int ans=0;

        for(Character i : map.keySet()){
            for(Character j : map.keySet()){
                if(i==j)continue;

                int c1=0, c2=0;
                int total = map.get(j);

                for(char ch : s.toCharArray()){
                    if(ch == i)c1++;
                    if(ch == j){
                        c2++;
                        total--;
                    }

                    if(c2 > 0)ans = Math.max(ans, c1-c2);
                    if(c1-c2 <0 && total >0){
                        c1=0;
                        c2=0;
                    }
                }

            }
        }
        return ans;
    }
}