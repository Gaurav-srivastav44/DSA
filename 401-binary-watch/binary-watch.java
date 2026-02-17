class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();

        for(int h=0; h<12; h++){
            for(int m=0; m<60; m++){
                if(Integer.bitCount(h) + Integer.bitCount(m) == turnedOn){
                    if(m < 10)
                        ans.add(h + ":0" + m);
                    else
                        ans.add(h + ":" + m);
                }
            }
        }
        return ans;
    }
}