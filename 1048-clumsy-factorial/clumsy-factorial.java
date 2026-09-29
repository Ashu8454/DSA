class Solution {
    public int clumsy(int n) {
        if (n <= 4) {
            return new int[]{0, 1, 2, 6, 7}[n];
        }
        

        int[] offsets = {1, 2, 2, -1};
        
        return n + offsets[n % 4];
    }
}
