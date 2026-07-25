import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] memo1 = new int[n];
        int[] memo2 = new int[n];
        
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);

        int choice1 = solve(nums, 0, n - 2, memo1);
        int choice2 = solve(nums, 1, n - 1, memo2);

        return Math.max(choice1, choice2);
    }

    private int solve(int[] nums, int i, int end, int[] memo) {
        if (i > end) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int rob = nums[i] + solve(nums, i + 2, end, memo);

        int skip = solve(nums, i + 1, end, memo);

        return memo[i] = Math.max(rob, skip);
    }
}
