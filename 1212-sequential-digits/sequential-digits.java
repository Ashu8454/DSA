import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; i <= 9; i++) {
            generateSequential(i, low, high, result);
        }
        
        Collections.sort(result);
        return result;
    }
    
    private void generateSequential(long currentNum, int low, int high, List<Integer> result) {
        if (currentNum > high) {
            return;
        }
        
        if (currentNum >= low) {
            result.add((int) currentNum);
        }
        
        long lastDigit = currentNum % 10;
        
        if (lastDigit < 9) {
            long nextNum = currentNum * 10 + (lastDigit + 1);
            generateSequential(nextNum, low, high, result);
        }
    }
}
