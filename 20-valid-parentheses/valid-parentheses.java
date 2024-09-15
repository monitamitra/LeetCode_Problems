class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                st.push(')');
            } else if (curr == '{') {
                st.push('}');
            } else if (curr == '[') {
                st.push(']');
            } else if (st.isEmpty() || st.pop() != s.charAt(i)) {
                return false;
            } 
        }
        // if still chars left that means every char did not have a match
        return st.isEmpty();
    }
}