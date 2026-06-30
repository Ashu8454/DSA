class Solution {
    public int numberOfSubstrings(String s) {
        int a = -1, b = -1, c = -1;
        int ci = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            
            if (ch == 'a') {
                a = i;
            } else if (ch == 'b') {
                b = i;
            } else if (ch == 'c') {
                c = i;
            }
            
            if (a != -1 && b != -1 && c != -1) {
                ci += Math.min(a, Math.min(b, c)) + 1;
            }
        }
        
        return ci;
    }
}
