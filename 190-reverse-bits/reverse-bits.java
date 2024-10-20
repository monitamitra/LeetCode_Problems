public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            // shift i bits to right and extract LSB (rightmost bit) 
            int bit = (n >> i) & 1;
            // putting prev LSB and placing it in MSB (other left side)
            // of output number 
            // putting changed bit into res
            res = res | (bit << (31 - i));
        }
        return res;
    }
}