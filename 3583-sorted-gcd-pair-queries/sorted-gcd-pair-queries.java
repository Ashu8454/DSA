import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        // 1. Sabse bada element dhoondo taaki sieve ka size pta chale
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Frequency table banayein
        int[] freq = new int[maxVal + 1];
        for (int num : nums) {
            freq[num]++;
        }

        // 2. Sieve loop: dhoondo ki har 'i' ke kitne multiples hain array mein
        long[] gcdCount = new long[maxVal + 1];
        for (int i = maxVal; i >= 1; i--) {
            long totalMultiples = 0;
            for (int j = i; j <= maxVal; j += i) {
                totalMultiples += freq[j];
            }

            // Total pairs jo 'i' se divide hote hain
            long totalPairs = totalMultiples * (totalMultiples - 1) / 2;

            // Inclusion-Exclusion: Bade multiples ke counts ko minus karo
            for (int j = 2 * i; j <= maxVal; j += i) {
                totalPairs -= gcdCount[j];
            }
            gcdCount[i] = totalPairs;
        }

        // 3. Prefix Sum array banayein taaki index ranges pta chal sakein
        long[] prefixSum = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSum[i] = prefixSum[i - 1] + gcdCount[i];
        }

        // 4. Har query ke liye Binary Search lagayein
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = binarySearch(prefixSum, queries[i], maxVal);
        }

        return ans;
    }

    // Binary search helper function range dhoondne ke liye
    private int binarySearch(long[] prefixSum, long query, int maxVal) {
        int low = 1, high = maxVal;
        int result = maxVal;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Agar query prefixSum[mid] se choti hai, matlab answer mid ya uske left mein hai
            if (prefixSum[mid] > query) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}
