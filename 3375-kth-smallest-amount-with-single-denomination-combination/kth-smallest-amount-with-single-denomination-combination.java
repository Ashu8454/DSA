class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        long high = 25L * k;
        long ans = high;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            
            if (countValidAmounts(coins, mid) >= k) {
                ans = mid;       
                high = mid - 1;
            } else {
                low = mid + 1;  
            }
        }
        
        return ans;
    }
    
    private long countValidAmounts(int[] coins, long mid) {
        long total = 0;
        int n = coins.length;
        int subsets = 1 << n;
        
        for (int i = 1; i < subsets; i++) {
            long lcmVal = 1;
            int setBits = 0;
            
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    setBits++;
                    lcmVal = lcm(lcmVal, coins[j]);
                    if (lcmVal > mid) break;
                }
            }
            
            if (lcmVal <= mid) {
       if (setBits % 2 == 1) {
                    total += mid / lcmVal;
                } else {
                    total -= mid / lcmVal;
                }
            }
        }
        return total;
    }
    
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
    
    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}