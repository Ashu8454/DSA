class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        
        // Edge Cases
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        // n >= 3 के लिए, n में टोटल कितने बिट्स हैं वो निकालो
        int bitLength = Integer.toBinaryString(n).length();
        
        // आंसर 2^bitLength होगा
        return 1 << bitLength; 
    }
}