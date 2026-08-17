import java.util.Arrays;

class Solution {
    int[][] memo;
    int[] prefixSum;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        
        // Memoization table ko -1 se initialize karein
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Prefix Sum array banana taaki O(1) mein range sum mil sake
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }

        // Pure array ke liye recursion call karein
        return solve(0, n - 1);
    }

    private int solve(int left, int right) {
        // Base Case: Agar sirf ek hi stone bacha hai
        if (left == right) {
            return 0;
        }

        // Agar yeh state pehle se calculated hai
        if (memo[left][right] != -1) {
            return memo[left][right];
        }

        int maxScore = 0;

        // Har possible point 'i' par array ko split karke check karein
        for (int i = left; i < right; i++) {
            int leftSum = getRangeSum(left, i);
            int rightSum = getRangeSum(i + 1, right);

            if (leftSum < rightSum) {
                // Bob right row fenk dega, Alice ko leftSum milega
                maxScore = Math.max(maxScore, leftSum + solve(left, i));
            } else if (rightSum < leftSum) {
                // Bob left row fenk dega, Alice ko rightSum milega
                maxScore = Math.max(maxScore, rightSum + solve(i + 1, right));
            } else {
                // Agar dono barabar hain, toh Alice decide karegi kaun sa rakhna hai
                int chooseLeft = leftSum + solve(left, i);
                int chooseRight = rightSum + solve(i + 1, right);
                maxScore = Math.max(maxScore, Math.max(chooseLeft, chooseRight));
            }
        }

        // Result store karein aur return karein
        return memo[left][right] = maxScore;
    }

    // Helper function range ka sum nikalne ke liye
    private int getRangeSum(int start, int end) {
        return prefixSum[end + 1] - prefixSum[start];
    }
}
