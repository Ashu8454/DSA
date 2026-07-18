import java.util.Arrays;

class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        
        int totalRabbits = 0;
        int n = answers.length;
        
        int i = 0;
        while (i < n) {
            int x = answers[i]; 
            int groupSize = x + 1; 
            
            totalRabbits += groupSize;
            
            int count = 0;
            while (i < n && answers[i] == x && count < groupSize) {
                count++;
                i++;
            }
        }
        
        return totalRabbits;
    }
}