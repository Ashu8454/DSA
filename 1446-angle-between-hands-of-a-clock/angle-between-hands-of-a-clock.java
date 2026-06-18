class Solution {
    public double angleClock(int hour, int minutes) {
        if (hour == 12) {
            hour = 0;
        }
        
        double t = (30 * hour) - (5.5 * minutes);
        
        if (t < 0) {
            t = -t;
        }
        
        if (t > 180) {
            return 360 - t;
        }
        
        return t;
    }
}
