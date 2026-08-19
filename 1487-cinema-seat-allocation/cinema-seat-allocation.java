import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Map to store row number and its seat reservation bitmask
        Map<Integer, Integer> rowMasks = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            // We only care about seats 2 through 9
            if (col >= 2 && col <= 9) {
                rowMasks.put(row, rowMasks.getOrDefault(row, 0) | (1 << col));
            }
        }
        
        // Convert the masks of reserved rows into a list for recursion
        List<Integer> masks = new ArrayList<>(rowMasks.values());
        
        // Any row with absolutely no reservations can automatically fit 2 families
        int completelyEmptyRows = n - rowMasks.size();
        int initialCount = completelyEmptyRows * 2;
        
        // Use divide-and-conquer recursion to find total families from reserved rows
        return initialCount + countFamiliesRecursive(masks, 0, masks.size() - 1);
    }
    
    private int countFamiliesRecursive(List<Integer> masks, int start, int end) {
        // Base case 1: No rows to process
        if (start > end) {
            return 0;
        }
        
        // Base case 2: Single row to process
        if (start == end) {
            int mask = masks.get(start);
            
            // Precomputed bitmasks for the 3 possible seating options:
            // Left block (seats 2,3,4,5)   -> (1<<2)|(1<<3)|(1<<4)|(1<<5) = 60
            // Right block (seats 6,7,8,9)  -> (1<<6)|(1<<7)|(1<<8)|(1<<9) = 960
            // Middle block (seats 4,5,6,7) -> (1<<4)|(1<<5)|(1<<6)|(1<<7) = 240
            boolean leftFree = (mask & 60) == 0;
            boolean rightFree = (mask & 960) == 0;
            boolean middleFree = (mask & 240) == 0;
            
            if (leftFree && rightFree) {
                return 2; // Can fit both left and right blocks
            }
            if (leftFree || rightFree || middleFree) {
                return 1; // Can fit exactly one block
            }
            return 0; // Cannot fit any family group
        }
        
        // Recursive Step: Divide and Conquer
        int mid = start + (end - start) / 2;
        return countFamiliesRecursive(masks, start, mid) + 
               countFamiliesRecursive(masks, mid + 1, end);
    }
}
