class Solution {
    public int countKthRoots(int l, int r, int k) {
        if (k == 1) {
            return r - l + 1;
        }

        int count = 0;
        for (long x = 0; ; x++) {
            long power = (long) Math.pow(x, k);
            
            if (power > r) {
                break;
            }
            
            if (power >= l) {
                count++;
            }
        }
        
        return count;
    }
}
