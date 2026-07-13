import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        
        // Start recursion for numbers beginning with digits 1 to 9
        for (int i = 1; i <= 9; i++) {
            generateSequential(i, low, high, result);
        }
        
        // Sort the list to ensure ascending order
        Collections.sort(result);
        return result;
    }
    
    private void generateSequential(long currentNum, int low, int high, List<Integer> result) {
        // Base case: if current number exceeds high, stop recursion
        if (currentNum > high) {
            return;
        }
        
        // If current number is within the valid range, add it to the result
        if (currentNum >= low) {
            result.add((int) currentNum);
        }
        
        // Extract the last digit of the current number
        long lastDigit = currentNum % 10;
        
        // If the last digit is less than 9, we can append the next consecutive digit
        if (lastDigit < 9) {
            long nextNum = currentNum * 10 + (lastDigit + 1);
            generateSequential(nextNum, low, high, result);
        }
    }
}
