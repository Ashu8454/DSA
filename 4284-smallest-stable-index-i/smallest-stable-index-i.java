class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
                    int max = Integer.MIN_VALUE;;

        for (int i = 0; i < n; i++) { 
            int min = Integer.MAX_VALUE;
            if(nums[i]>max) max=nums[i];
            for (int j = i; j < n; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                }
            }
            
            int x = max - min;
            if (x <= k) {
                return i;
            }
        }
        return -1;
    }
}
