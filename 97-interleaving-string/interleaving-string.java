import java.util.Arrays;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();
        
        Boolean[][] memo = new Boolean[str1.length + 1][str2.length + 1];
        
        return check(str1, str2, str3, 0, 0, 0, memo);
    }
    
    private boolean check(char[] str1, char[] str2, char[] str3, int i, int j, int k, Boolean[][] memo) {
        if (k == str3.length) {
            return true;
        }
        
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        boolean match1 = false;
        boolean match2 = false;
        
        if (i < str1.length && str1[i] == str3[k]) {
            match1 = check(str1, str2, str3, i + 1, j, k + 1, memo);
        }
        
        if (j < str2.length && str2[j] == str3[k]) {
            match2 = check(str1, str2, str3, i, j + 1, k + 1, memo);
        }
        
        return memo[i][j] = match1 || match2;
    }
}
