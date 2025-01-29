class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        
        // Step 1: Store words and their indices in a HashMap
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }

        // Step 2: Check each word for palindrome pairs
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int wordLen = word.length();

            for (int j = 0; j <= wordLen; j++) { // j == wordLen handles empty suffix case
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);

                // Case 1: If prefix is a palindrome, check for reversed suffix
                if (isPalindrome(prefix)) {
                    String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                    if (wordMap.containsKey(reversedSuffix) && wordMap.get(reversedSuffix) != i) {
                        result.add(Arrays.asList(wordMap.get(reversedSuffix), i));
                    }
                }

                // Case 2: If suffix is a palindrome, check for reversed prefix
                if (suffix.length() > 0 && isPalindrome(suffix)) { // Avoid duplicates
                    String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                    if (wordMap.containsKey(reversedPrefix) && wordMap.get(reversedPrefix) != i) {
                        result.add(Arrays.asList(i, wordMap.get(reversedPrefix)));
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}