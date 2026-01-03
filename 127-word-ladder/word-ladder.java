class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int level = 1;

        while(!q.isEmpty()){
            int n = q.size();

            for(int i=0; i<n; i++){
                String word = q.poll();
                char[] arr = word.toCharArray();

                for(int j=0; j<arr.length; j++){
                    char old = arr[j];

                    for(char ch='a'; ch<='z'; ch++){
                        arr[j] = ch;
                        String change = new String(arr);

                        if(change.equals(endWord))
                            return level + 1;

                        if(set.contains(change)){
                            q.add(change);
                            set.remove(change); 
                        }
                    }
                    arr[j] = old;
                }
            }
            level++;
        }
        return 0;
    }
}
