class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }
    
    private int helper(String s, int start, int end, int k) {
        if (end - start < k) return 0;
        
        int[] counts = new int[26];
        for (int i = start; i < end; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        
        for (int i = start; i < end; i++) {
            char ch = s.charAt(i);
            if (counts[ch - 'a'] > 0 && counts[ch - 'a'] < k) {
                
                int leftPartLength = helper(s, start, i, k);
                int rightPartLength = helper(s, i + 1, end, k);
                
                return Math.max(leftPartLength, rightPartLength);
            }
        }
        
    
        return end - start;
    }
}
