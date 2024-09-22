class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> charSt = new Stack<>();
        Stack<Integer> countSt = new Stack<>();
        int curr = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                curr = curr * 10 + (ch - '0');
            } else if (ch == '[') {
                countSt.push(curr);
                curr = 0;
                charSt.push(sb);
                sb = new StringBuilder();
            } else if (ch == ']') {
                int k = countSt.pop();
                StringBuilder temp = sb;
                sb = charSt.pop();
                while (k > 0) {
                    k--;
                    sb.append(temp);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}