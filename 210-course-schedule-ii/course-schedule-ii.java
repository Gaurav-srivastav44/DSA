class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            g.add(new ArrayList<>());
        }

        int[] id = new int[numCourses];

        for(int[] i : prerequisites){
            g.get(i[1]).add(i[0]);
            id[i[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(id[i] == 0){
                q.add(i);
            }
        }
        
        int[] ans = new int[numCourses];
        int c=0;
        while(!q.isEmpty()){
            int n= q.poll();
            ans[c++] = n;
            for(int key : g.get(n)){
                id[key]--;
                if(id[key] == 0){
                    q.add(key);
                }
            }
        }

        if(c == numCourses)return ans;
        else return new int[0];
    }
}