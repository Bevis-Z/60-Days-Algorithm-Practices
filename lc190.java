public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Extract the rightmost bit of n
            int bit = (n >> i) & 1;
            // Shift the bit to its reverse position and add it to result
            result |= (bit << (31 - i));
        }
        return result;
    }
}