import java.util.Arrays;

class Solution {
    private final long MAX = 1000005;

    public String smallestPalindrome(String s, int k) {
        int[] totalCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            totalCounts[s.charAt(i) - 'a']++;
        }

        char midChar = 0;
        int[] halfCounts = new int[26];
        int halfLen = 0;

        for (int i = 0; i < 26; i++) {
            if (totalCounts[i] % 2 != 0) {
                midChar = (char) (i + 'a');
            }
            halfCounts[i] = totalCounts[i] / 2;
            halfLen += halfCounts[i];
        }

        if (countArrangements(halfCounts) < k) {
            return "";
        }

        StringBuilder leftHalf = new StringBuilder();
        long currK = k;

        for (int i = 0; i < halfLen; i++) {
            for (int c = 0; c < 26; c++) {
                if (halfCounts[c] == 0) continue;

                halfCounts[c]--;
                long arrangements = countArrangements(halfCounts);

                if (arrangements >= currK) {
                    leftHalf.append((char) (c + 'a'));
                    break;
                } else {
                    currK -= arrangements;
                    halfCounts[c]++;
                }
            }
        }

        String left = leftHalf.toString();
        String right = leftHalf.reverse().toString();

        if (midChar != 0) {
            return left + midChar + right;
        }
        return left + right;
    }

    private long countArrangements(int[] counts) {
        int total = 0;
        for (int c : counts) total += c;

        long res = 1;
        for (int freq : counts) {
            if (freq == 0) continue;
            res = multiplyCapped(res, nCk(total, freq));
            if (res >= MAX) return MAX;
            total -= freq;
        }
        return res;
    }

    private long nCk(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;
        if (k > n - k) k = n - k;

        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = (res * (n - i + 1)) / i;
            if (res >= MAX) return MAX;
        }
        return res;
    }

    private long multiplyCapped(long a, long b) {
        if (a == 0 || b == 0) return 0;
        if (a >= MAX || b >= MAX) return MAX;
        if (a > MAX / b) return MAX;
        return a * b;
    }
}
