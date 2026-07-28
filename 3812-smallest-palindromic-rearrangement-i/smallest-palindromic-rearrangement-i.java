import java.util.Arrays;

class Solution {
    public String smallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        
        int[] counts = new int[26];
        for (char c : chars) {
            counts[c - 'a']++;
        }
        
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] % 2 != 0) {
                midChar = (char) (i + 'a');
                counts[i]--;
                break;
            }
        }
        
        StringBuilder leftHalf = new StringBuilder();
        buildLeft(counts, 0, leftHalf);
        
        String left = leftHalf.toString();
        String right = leftHalf.reverse().toString();
        
        if (midChar != 0) {
            return left + midChar + right;
        }
        return left + right;
    }
    
    private void buildLeft(int[] counts, int index, StringBuilder sb) {
        if (index >= counts.length) {
            return;
        }
        if (counts[index] > 0) {
            sb.append((char) (index + 'a'));
            counts[index] -= 2;
            buildLeft(counts, index, sb);
        } else {
            buildLeft(counts, index + 1, sb);
        }
    }
}
