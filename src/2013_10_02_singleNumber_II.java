public class Solution {
    // Given an array of integers, every element appears three 
    // times except for one. Find that single one.

    // Note:
    // Your algorithm should have a linear runtime complexity. 
    // Could you implement it without using extra memory?

    // O(n) time, O(1) space
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) return -1;
        int one = 0, two = 0, three = 0;
        for (int n : A) {
            two |= one & n;
            one ^= n;
            three = ~(one & two);
            one &= three;
            two &= three;
        }
        return one;
    }
    
    // O(n) time, O(32) space
    public int singleNumber2(int[] A) {
        if (A == null || A.length == 0) return -1;
        int ret = 0;
        int[] bitCount = new int[32];
        for (int i = 0; i < bitCount.length; ++i) {
            for (int n : A) {
                // Here should prefer ((n >> i) & 1) > 0 rather than n & (1 << i)) > 0
                // since >> (arithmetic shift right) preserves the signedness of number
                // and the test cases contain negative numbers. If we don't need to
                // consider the signedness then the two notations are equivalent.
                if (((n >> i) & 1) > 0) {
                    bitCount[i] = ++bitCount[i] % 3;
                }
            }
            ret |= bitCount[i] << i;
        }
        return ret;
    }
}