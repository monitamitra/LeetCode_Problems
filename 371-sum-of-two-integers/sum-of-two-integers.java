class Solution {
    public int getSum(int a, int b) {
        // while carry is not zero
        while (b != 0) {
            int temp = (a & b) << 1;
            a ^= b;
            b = temp;
        }
        return a;
    }
}