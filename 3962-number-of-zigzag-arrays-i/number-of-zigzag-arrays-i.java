class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1_000_000_007;
        int k = r - l + 1; 
        if (k <= 1) return 0;
        
        int[][] dp = new int[k + 1][2];
        
        for (int v = 1; v <= k; v++) {
            dp[v][0] = v - 1; 
            dp[v][1] = k - v;
        }
        
        // Build DP for lengths from 3 up to n
        for (int len = 3; len <= n; len++) {
            int[][] newDp = new int[k + 1][2];
            
            long sumDown = 0;
            for (int v = 1; v <= k; v++) {
                newDp[v][0] = (int) sumDown;
                sumDown = (sumDown + dp[v][1]) % MOD;
            }
            
            long sumUp = 0;
            for (int v = k; v >= 1; v--) {
                newDp[v][1] = (int) sumUp;
                sumUp = (sumUp + dp[v][0]) % MOD;
            }
            
            dp = newDp; 
        }
        
        long totalWays = 0;
        for (int v = 1; v <= k; v++) {
            totalWays = (totalWays + dp[v][0]) % MOD;
            totalWays = (totalWays + dp[v][1]) % MOD;
        }
        
        return (int) totalWays;
    }
}