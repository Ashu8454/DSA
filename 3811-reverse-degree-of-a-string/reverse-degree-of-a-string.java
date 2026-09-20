class Solution {
    public int reverseDegree(String s) {
        int c = 0;
for (int i = 0; i < s.length(); i++) {
    int res = 123 - s.charAt(i);
    c += res * (i + 1);
}
return c;
    }
}