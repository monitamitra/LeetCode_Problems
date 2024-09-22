class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> charSt = new Stack<>();
        Stack<Integer> countSt = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!charSt.isEmpty() && charSt.peek() == s.charAt(i)) {
                countSt.push(countSt.peek() + 1);
            } else {
                countSt.push(1);
            }
            charSt.push(s.charAt(i));
            if (countSt.peek() == k) {
                for (int j = 0; j < k; j++) {
                    charSt.pop();
                    countSt.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!charSt.isEmpty()) {
            sb.append(charSt.pop());
        }
        return sb.reverse().toString();
    }
}