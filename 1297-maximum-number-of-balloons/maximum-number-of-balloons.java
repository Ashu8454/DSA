
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        
        for (char c : text.toCharArray()) {
            counts[c - 'a']++;
        }
        
        int b = counts['b' - 'a'];
        int a = counts['a' - 'a'];
        int l = counts['l' - 'a'] / 2;
        int o = counts['o' - 'a'] / 2;
        int n = counts['n' - 'a'];
        
        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}
