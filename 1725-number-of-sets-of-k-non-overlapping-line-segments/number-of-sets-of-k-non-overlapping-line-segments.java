class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        
        int totalPoints = n + k - 1;
        int targetChoices = 2 * k;
        
        if (targetChoices > totalPoints) return 0;
        
        long[] dp = new long[targetChoices + 1];
        dp[0] = 1; 
        
        for (int i = 1; i <= totalPoints; i++) {
            for (int j = Math.min(i, targetChoices); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % MOD;
            }
        }
        
        return (int) dp[targetChoices];
    }
}
