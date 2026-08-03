class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            int take1 = stoneValue[i] - dp[i + 1];
            
            int take2 = Integer.MIN_VALUE;
            if (i + 1 < n) {
                take2 = stoneValue[i] + stoneValue[i + 1] - dp[i + 2];
            }
            
            int take3 = Integer.MIN_VALUE;
            if (i + 2 < n) {
                take3 = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3];
            }
            
            dp[i] = Math.max(take1, Math.max(take2, take3));
        }
        
        int finalDiff = dp[0];
        if (finalDiff > 0) {
            return "Alice";
        } else if (finalDiff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}
