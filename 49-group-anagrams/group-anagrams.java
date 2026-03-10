class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            String key = Arrays.toString(arr);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        //isme har string par iterate kar rahe hai use sort karke check kar rahe hai pehle aa chuki hogi to uski value(jo ki arraylist hai) usme add kar denge

        List<List<String>> ans = new ArrayList<>(map.values());
        return ans;



    }
}