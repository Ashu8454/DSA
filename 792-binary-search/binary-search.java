class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        return h(nums,target,0,n-1);

    }
    public int h(int[] nums, int target,int lo, int hi){
        int mid= lo+(hi-lo)/2;
        if(lo>hi) return -1;
        if(nums[mid]==target) return mid;
        else if(nums[mid]>target)  return h(nums,target,lo,mid-1);
        else{
         return h(nums,target,mid+1,hi);
        }
    }
}