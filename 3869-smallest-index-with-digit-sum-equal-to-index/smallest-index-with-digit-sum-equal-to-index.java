class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        int j=0;
        while(j<n){
            int sum=0;
            int t=nums[j];
            while(t>0){
                int r=t%10;
                sum+=r;
                t/=10;
            }
            if(sum==j) return j;
            j++;
        }
        return -1;
    }
}