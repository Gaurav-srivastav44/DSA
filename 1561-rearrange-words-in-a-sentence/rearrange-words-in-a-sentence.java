class Solution {
    public String arrangeWords(String text) {
        String[] words = text.toLowerCase().split(" ");
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        StringBuilder sb = new StringBuilder(String.join(" ", words));
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        
        return sb.toString();
    }
}
