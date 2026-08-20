import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        // Map each Roman numeral to its integer value
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int total = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int currentVal = romanMap.get(s.charAt(i));
            
            // If current value is less than the next value, subtract it
            if (i < n - 1 && currentVal < romanMap.get(s.charAt(i + 1))) {
                total -= currentVal;
            } else {
                // Otherwise, add it to the total
                total += currentVal;
            }
        }
        
        return total;
    }
}
