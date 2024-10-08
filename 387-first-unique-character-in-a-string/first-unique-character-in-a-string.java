class Solution {
    public int firstUniqChar(String s) {
        int[] a = new int[26];
        Arrays.fill(a, 0);

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            a[curr - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (a[curr - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}