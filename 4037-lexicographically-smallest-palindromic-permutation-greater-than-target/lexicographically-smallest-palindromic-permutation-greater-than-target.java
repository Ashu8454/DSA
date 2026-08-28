class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        char[] sChars = s.toCharArray();
        char[] tChars = target.toCharArray();
        int n = sChars.length;
        
        int[] cnt = new int[26];
        for (char c : sChars) {
            cnt[c - 'a']++;
        }
        
     
        boolean hasOdd = false;
        char mid = 0;
        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                if (hasOdd) return "";
                hasOdd = true;
                mid = (char) (i + 'a');
                cnt[i]--; 
            }
        }
        
        int half = n / 2;
        int idx = 0;
        boolean deviationFound = false;
        
        for (; idx < half; idx++) {
            int tIdx = tChars[idx] - 'a';
            
            if (cnt[tIdx] == 0) {
                for (int j = tIdx + 1; j < 26; j++) {
                    if (cnt[j] > 0) {
                        sChars[idx] = (char) (j + 'a');
                        cnt[j] -= 2; 
                        deviationFound = true;
                        break;
                    }
                }
                break;
            }
            
            cnt[tIdx] -= 2;
            sChars[idx] = tChars[idx];
        }
        
        if (!deviationFound && idx >= half) {
            if (n % 2 != 0 && mid > tChars[half]) {
                deviationFound = true;
            } 
            else if (n % 2 == 0 || mid == tChars[half]) {
                for (int i = half - 1; i >= 0; i--) {
                    if (sChars[i] > tChars[n - i - 1]) {
                        deviationFound = true;
                        break;
                    }
                    if (sChars[i] < tChars[n - i - 1]) {
                        break; 
                    }
                }
            }
        }
        
        if (!deviationFound) {
            outer: for (--idx; idx >= 0; idx--) {
                int tIdx = tChars[idx] - 'a';
                cnt[tIdx] += 2; 
                
                for (int j = tIdx + 1; j < 26; j++) {
                    if (cnt[j] > 0) {
                        sChars[idx] = (char) (j + 'a');
                        cnt[j] -= 2;
                        deviationFound = true;
                        break outer;
                    }
                }
            }
        }
        
        if (!deviationFound) return "";
        
        for (++idx; idx < half; idx++) {
            for (int j = 0; j < 26; j++) {
                if (cnt[j] > 0) {
                    sChars[idx] = (char) (j + 'a');
                    cnt[j] -= 2;
                    break;
                }
            }
        }
        
        String leftPart = new String(sChars, 0, half);
        StringBuilder sb = new StringBuilder(leftPart);
        sb.reverse().insert(0, leftPart); 
        
        if (n % 2 != 0) {
            sb.insert(half, mid); 
        }
        
        return sb.toString();
    }
}
