class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int count = 0;
        StringBuilder ans = new StringBuilder();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            }
            else {
                map.put(t.charAt(i), 1);
                count++;
            }
        }

        while(end < s.length()) {
            char chEnd = s.charAt(end);
            if(map.containsKey(chEnd)) {
                map.put(chEnd, map.get(chEnd) - 1);
                if(map.get(chEnd) == 0) {
                    count--;
                }
            }

            if(count == 0) {
                while(count == 0) {
                    if(map.containsKey(s.charAt(start))) {
                        if(map.get(s.charAt(start)) < 0) {
                            map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                        }
                        else if(map.get(s.charAt(start)) == 0) {
                            if(end - start + 1 < min) {
                                min = end - start + 1;
                                ans.setLength(0);
                                for(int i = start; i < end + 1; i++) {
                                    ans.append(s.charAt(i));
                                }
                            }
                            map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                            if(map.get(s.charAt(start)) == 1) {
                                count++;
                            }
                        }
                    }
                    start++;
                }
            }
            end++;
        }
        return ans.toString();
    }
}