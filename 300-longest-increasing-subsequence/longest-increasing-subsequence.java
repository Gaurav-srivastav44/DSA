class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int num : nums){
            int i = Collections.binarySearch(temp,num);

            if(i<0){
                i = -(i+1);
            }
            if(i == temp.size()){
                temp.add(num);
            }
            else{
                temp.set(i,num);
            }
        }
        return (temp.size());
    }
}