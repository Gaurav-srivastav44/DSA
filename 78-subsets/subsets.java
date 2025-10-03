class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int l = 1<<nums.length; // ya 2^n ie(Math.pow);

        for(int i=0; i<l ;i++){
            List<Integer> cur=new ArrayList<>();
            
            for(int j=0;j<nums.length;j++){
                int k = 1<<j;
                if((i&k) > 0){
                    cur.add(nums[j]);
                }
            }

            res.add(cur);
        }
        return res;
    }
}
/*ye problem Subsets generate karne ki hai. Main isko bitmasking technique se solve kar raha hoon.
Total subsets 2^n hote hain, kyunki har element ko ya to include kar sakte hain ya exclude.
Main har subset ko ek binary number se represent kar raha hoon:

Bit 1 → element include
Bit 0 → element exclude

Pehle, 1 << nums.length se total combinations nikalte hain. Ye 2^n ke barabar hai.

Fir outer loop i se har subset ka mask iterate karte hain.
Inner loop j se har element check karte hain:

(i & (1 << j)) > 0 → iska matlab jth element subset me include hoga.

Har subset cur list me add karte hain, aur finally res me store kar dete hain.

Dry Run Example, nums = [1,2]:
i=0 → 00 → subset = []
i=1 → 01 → subset = [1]
i=2 → 10 → subset = [2]
i=3 → 11 → subset = [1,2]
*/