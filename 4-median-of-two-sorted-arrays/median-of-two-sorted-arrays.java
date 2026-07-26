class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int o = n+m;
        int a[]  = new int[o];
        for(int i=0;i<n;i++){
            a[i]= nums1[i];

        }
        for(int i = 0; i < m; i++){ 
            a[n + i] = nums2[i]; 
        } 
        Arrays.sort(a);
        if(o%2==0){
            int y = o/2;
            double ans = (a[y]+a[y-1])/2.0;
            return ans;

        }
        return a[o/2];
    }
}