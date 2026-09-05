class Solution {
    public boolean isGoodArray(int[] nums) {
        int runningGcd = nums[0];
        
        if (runningGcd == 1) return true;
        
        for (int i = 1; i < nums.length; i++) {
            runningGcd = gcd(runningGcd, nums[i]);
            
      
            if (runningGcd == 1) {
                return true;
            }
        }
        
        return runningGcd == 1;
    }
    
   private int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

}
