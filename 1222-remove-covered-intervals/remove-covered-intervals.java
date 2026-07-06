import java.util.*;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        
        int remaining = 0;
        int currEnd = 0;
        
        for (int[] curr : intervals) {
            if (curr[1] > currEnd) {
                remaining++;
                currEnd = curr[1];
            }
        }
        
        return remaining;
    }
}
