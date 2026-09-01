import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {

        if (timePoints.size() > 1440) {
            return 0;
        }
        
        List<Integer> minutesList = new ArrayList<>();
        for (String time : timePoints) {
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3, 5));
            minutesList.add(h * 60 + m);
        }
        
        Collections.sort(minutesList);
        
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 1; i < minutesList.size(); i++) {
            int diff = minutesList.get(i) - minutesList.get(i - 1);
            minDiff = Math.min(minDiff, diff);
        }
 
        int circularDiff = (1440 - minutesList.get(minutesList.size() - 1)) + minutesList.get(0);
        minDiff = Math.min(minDiff, circularDiff);
        
        return minDiff;
    }
}
