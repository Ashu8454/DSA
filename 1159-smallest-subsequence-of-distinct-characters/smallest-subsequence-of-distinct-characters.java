import java.util.HashMap;

class Solution {
    public String smallestSubsequence(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        
        HashMap<Character, Integer> lastOcc = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOcc.put(s.charAt(i), i);
        }
        
        int minLastPos = s.length();
        for (int pos : lastOcc.values()) {
            if (pos < minLastPos) {
                minLastPos = pos;
            }
        }
        
        char smallestChar = 'z' + 1;
        int smallestIdx = 0;
        
        for (int i = 0; i <= minLastPos; i++) {
            if (s.charAt(i) < smallestChar) {
                smallestChar = s.charAt(i);
                smallestIdx = i;
            }
        }
        
        String nextS = s.substring(smallestIdx + 1).replace(String.valueOf(smallestChar), "");
        
        return smallestChar + smallestSubsequence(nextS);
    }
}
