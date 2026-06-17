class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] lengths = new long[n + 1];
        lengths[0] = 0;
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            long currLen = lengths[i];
            
            if (ch == '*') {
                lengths[i + 1] = currLen > 0 ? currLen - 1 : 0;
            } else if (ch == '#') {
                lengths[i + 1] = currLen * 2;
            } else if (ch == '%') {
                lengths[i + 1] = currLen;
            } else {
                lengths[i + 1] = currLen + 1;
            }
        }
        
        if (k < 0 || k >= lengths[n]) {
            return '.';
        }
        
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long prevLen = lengths[i];
            
            if (ch == '*') {
                continue;
            } else if (ch == '#') {
                if (k >= prevLen) {
                    k -= prevLen;
                }
            } else if (ch == '%') {
                k = prevLen - 1 - k;
            } else {
                if (k == prevLen) {
                    return ch;
                }
            }
        }
        
        return '.';
    }
}