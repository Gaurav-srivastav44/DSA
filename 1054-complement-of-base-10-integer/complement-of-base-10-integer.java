class Solution {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        String str ="";
        for(char i : s.toCharArray()){
            if(i == '0'){
                str += ""+1;
            }
            else str += ""+0;
        }
        int num = Integer.parseInt(str, 2);
        return num;
    }
}