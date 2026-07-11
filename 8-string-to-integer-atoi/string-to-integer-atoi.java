class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return parseWhitespace(s, 0);
    }

    private int parseWhitespace(String s, int index) {
        if (index == s.length()) {
            return 0;
        }
        if (s.charAt(index) == ' ') {
            return parseWhitespace(s, index + 1);
        }
        return parseSign(s, index);
    }

    private int parseSign(String s, int index) {
        if (index == s.length()) {
            return 0;
        }
        int sign = 1;
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        return (int) parseDigits(s, index, sign, 0L); // यहाँ 0L (long) पास किया
    }

    private long parseDigits(String s, int index, int sign, long result) {
        // अगर रिजल्ट पहले ही लिमिट पार कर चुका है, तो आगे रीकर्शन करने की ज़रूरत नहीं
        if (sign == 1 && result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sign == -1 && -result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (index == s.length()) {
            return result * sign;
        }

        char ch = s.charAt(index);
        if (ch < '0' || ch > '9') {
            return result * sign;
        }

        long nextResult = result * 10 + (ch - '0');
        return parseDigits(s, index + 1, sign, nextResult);
    }
}
