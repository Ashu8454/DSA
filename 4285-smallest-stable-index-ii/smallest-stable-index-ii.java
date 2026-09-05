class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return -1;

        int[] suffMin = new int[n];
        suffMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }

    
        int currentPrefMax = nums[0];

        for (int i = 0; i < n; i++) {
            currentPrefMax = Math.max(currentPrefMax, nums[i]);
            
            int instabilityScore = currentPrefMax - suffMin[i];

            if (instabilityScore <= k) {
                return i;
            }
        }

        return -1; 
    }
}
