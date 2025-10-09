class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        
        for (String i : parts) {
            if (i.isEmpty() || i.equals(".")) continue;
            if (i.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(i);
            }
        }
        
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }
}
