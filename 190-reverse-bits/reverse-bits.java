public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            // take next bit from n and put in appropriate spot in output 
            int bit = (n >> i) & 1;
            res = res | (bit << (31 - i));
        }
        return res;
    }
}