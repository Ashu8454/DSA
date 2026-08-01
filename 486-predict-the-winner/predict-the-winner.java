import java.util.Arrays;

class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return maxScoreDifference(nums, 0, n - 1, memo) >= 0;
    }
    
    private int maxScoreDifference(int[] nums, int left, int right, int[][] memo) {
        if (left == right) {
            return nums[left];
        }
        
        if (memo[left][right] != -1) {
            return memo[left][right];
        }
        
        int pickLeft = nums[left] - maxScoreDifference(nums, left + 1, right, memo);
        int pickRight = nums[right] - maxScoreDifference(nums, left, right - 1, memo);
        
        memo[left][right] = Math.max(pickLeft, pickRight);
        return memo[left][right];
    }
}
