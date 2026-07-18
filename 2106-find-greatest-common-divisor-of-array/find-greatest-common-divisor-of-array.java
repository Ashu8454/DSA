class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int s = nums[0];
        int l = nums[nums.length-1];
        int max=0;
        for(int i=1;i<=l;i++){
            if(s%i==0&&l%i==0&&i>max){
                max=i;
            }
        }
        return max;
    }
}