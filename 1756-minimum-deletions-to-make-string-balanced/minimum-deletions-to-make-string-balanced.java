class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int b = 0;
        int d = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') { 
                b++;
            } else if (b > 0) {
               
                d = Math.min(b, d + 1);
            }
        }
        return d;
    }
}
