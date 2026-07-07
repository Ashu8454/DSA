class Solution {
    public long sumAndMultiply(int n) {
        long t = n;
        long sum = 0;
        long ne = 0;
        long m = 1;
        while (t > 0) {
            long r = t % 10;
            if (r != 0) {
                sum += r;
                ne = (r * m) + ne;
                m *= 10;
            }
            t /= 10;
        }
        return sum * ne;
    }
}