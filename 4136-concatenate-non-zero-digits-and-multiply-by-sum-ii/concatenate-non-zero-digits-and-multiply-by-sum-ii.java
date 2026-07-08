class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        long MOD = 1000000007L;
        
        // Prefix arrays ka jugaad - takki baar baar loop na chalana pade
        long[] sumD = new long[m + 1];
        int[] cntN0 = new int[m + 1];
        long[] p = new long[m + 1];
        long[] pow10 = new long[m + 1];
        
        // 10 ki powers ko pehle se calculate karke rakh lo
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        
        // PURI STRING PAR SIRF EK BAAR LOOP CHALEGA (O(m))
        for (int i = 0; i < m; i++) {
            int digit = s.charAt(i) - '0';
            sumD[i + 1] = sumD[i] + digit;
            
            if (digit != 0) {
                cntN0[i + 1] = cntN0[i] + 1;
                p[i + 1] = (p[i] * 10 + digit) % MOD;
            } else {
                cntN0[i + 1] = cntN0[i];
                p[i + 1] = p[i];
            }
        }
        
        // HAR QUERY BINA LOOP KE DIRECT ANSWER DEGI (O(1))
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            
            int count = cntN0[r + 1] - cntN0[l];
            long sum = sumD[r + 1] - sumD[l];
            
            // Substring ka number math logic se alag kar liya (Bina string slice kiye)
            long x = (p[r + 1] - (p[l] * pow10[count]) % MOD + MOD) % MOD;
            answer[i] = (int) ((x * sum) % MOD);
        }
        
        return answer;
    }
}