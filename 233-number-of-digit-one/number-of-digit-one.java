class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            
            count += (n / divider) * i;
            
            long remainder = n % divider;
            
            count += Math.max(0L, Math.min(i, remainder - i + 1));
        }
        
        return count;
    }
}
