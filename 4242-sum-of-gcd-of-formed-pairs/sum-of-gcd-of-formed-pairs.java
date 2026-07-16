import java.util.Arrays;

class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        
        buildPrefixGcd(nums, prefixGcd, 0, 0);
        
        Arrays.sort(prefixGcd);
        
        return calculatePairsSum(prefixGcd, 0, n - 1);
    }
    
    private void buildPrefixGcd(int[] nums, int[] prefixGcd, int index, int maxSoFar) {
        if (index == nums.length) {
            return;
        }
        int currentMax = Math.max(maxSoFar, nums[index]);
        prefixGcd[index] = gcd(nums[index], currentMax);
        buildPrefixGcd(nums, prefixGcd, index + 1, currentMax);
    }
    
    private long calculatePairsSum(int[] prefixGcd, int left, int right) {
        if (left >= right) {
            return 0L;
        }
        
        long currentPairGcd = gcd(prefixGcd[left], prefixGcd[right]);
        
        return currentPairGcd + calculatePairsSum(prefixGcd, left + 1, right - 1);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
