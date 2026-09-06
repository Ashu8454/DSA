class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        if (n < 3) {
            return false;
        }
        
        int aliceMoves = 0;
        int bobMoves = 0;
        
        for (int i = 1; i < n - 1; i++) {
            char current = colors.charAt(i);
            
            if (current == colors.charAt(i - 1) && current == colors.charAt(i + 1)) {
                if (current == 'A') {
                    aliceMoves++; 
                } else if (current == 'B') {
                    bobMoves++;   
                }
            }
        }
        
        return aliceMoves > bobMoves;
    }
}
