class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // putting frequencies of each character in s in a map
        HashMap<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!res.containsKey(s.charAt(i))) {
                res.put(s.charAt(i), 1);
            } else {
                int oldValue = res.get(s.charAt(i));
                res.put(s.charAt(i), oldValue + 1);
            }
        }

        // checking to see if every character in s is mapped to t
        for (int i = 0; i < t.length(); i++) {
            if (!res.containsKey(t.charAt(i))) {
                return false;
            } else {
                // efficient way to track frequency of each character in t related to s
                int oldValue = res.get(t.charAt(i));
                res.put(t.charAt(i), oldValue - 1);
            }
        }

        // each character has to appear the same amount of times in t and s
        // if not 0, that means t had more of that character than s
        for (char c : res.keySet()) {
            if (res.get(c) != 0) {
                return false;
            }
        }

        return true;

    }
}