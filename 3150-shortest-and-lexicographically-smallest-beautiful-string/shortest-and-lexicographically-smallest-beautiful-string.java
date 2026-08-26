class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int onesCount = 0;
        String result = "";

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                onesCount++;
            }

            while (onesCount == k) {
                String candidate = s.substring(left, right + 1);

                // Update result if it's the first one, shorter, or lexicographically smaller
                if (result.isEmpty() || candidate.length() < result.length()) {
                    result = candidate;
                } else if (candidate.length() == result.length() && candidate.compareTo(result) < 0) {
                    result = candidate;
                }

                // Shrink the window from the left
                if (s.charAt(left) == '1') {
                    onesCount--;
                }
                left++;
            }
        }

        return result;
    }
}
