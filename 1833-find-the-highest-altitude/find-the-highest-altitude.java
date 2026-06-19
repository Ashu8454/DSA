class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int a[]=new int [n+1];
        a[0]=0;
        a[1]=gain[0];
        int j=1;
        for(int i=2;i<=n;i++){
            a[i]=a[i-1]+gain[j];
            j++;
        }
        Arrays.sort(a);

        return a[n];
    }
}