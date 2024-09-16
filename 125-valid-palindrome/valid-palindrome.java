class Solution {
    public boolean isPalindrome(String s) {
        String temp = s.toLowerCase();
        int low = 0;
        int high = s.length() - 1;

        while (low <= high) {
            char curr1 = temp.charAt(low);
            char curr2 = temp.charAt(high);

            // checks if alphanumeric 
            if (!Character.isLetterOrDigit(curr1)) {
                low++;
            } else if (!Character.isLetterOrDigit(curr2)) {
                high--;
            } else {
                if (curr1 != curr2) {
                    return false;
                }
                
                low++;
                high--;
            }
        }
        return true;
    }
}