class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int l1=name.length();
        int l2=typed.length();

        int idx1=0;
        int idx2=0;
        while(idx1<l1 && idx2<l2){
            if(name.charAt(idx1) == typed.charAt(idx2)){
                idx1++;
                idx2++;
            }
            else if(idx1>0 && name.charAt(idx1-1) == typed.charAt(idx2)){
                idx2++;
            }
            else return false;
        }

        if(idx1<l1)return false;

        while(idx2<l2){
            if(name.charAt(l1-1) != typed.charAt(idx2))return false;
            idx2++;
        }
        return true;
        
       
    }
}