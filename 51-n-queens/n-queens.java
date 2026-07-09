import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Board ko pehle khaali '.' se bhar do
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // Attack tracks karne ke liye boolean arrays (Simple sets)
        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[2 * n];
        boolean[] antiDiag = new boolean[2 * n];
        
        solve(0, n, board, results, cols, diag, antiDiag);
        return results;
    }
    
    private void solve(int row, int n, char[][] board, List<List<String>> results, 
                       boolean[] cols, boolean[] diag, boolean[] antiDiag) {
        // Base Case: Agar saari rows bhar gayi, matlab solution mil gaya
        if (row == n) {
            results.add(buildBoard(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            // Row-Col negative na ho isliye (n - 1) add karte hain left diagonal mein
            int dIdx = row - col + n; 
            int adIdx = row + col;
            
            // Agar Queen attack ho rahi hai, toh is cell ko chhod do
            if (cols[col] || diag[dIdx] || antiDiag[adIdx]) {
                continue;
            }
            
            // Queen ko board par rakho aur track karo
            board[row][col] = 'Q';
            cols[col] = true;
            diag[dIdx] = true;
            antiDiag[adIdx] = true;
            
            // Agli row par jao
            solve(row + 1, n, board, results, cols, diag, antiDiag);
            
            // JUGAAAD / BACKTRACK: Wapas aate waqt board ko purana jaisa kar do
            board[row][col] = '.';
            cols[col] = false;
            diag[dIdx] = false;
            antiDiag[adIdx] = false;
        }
    }
    
    // Board ke state ko List<String> mein badalne ka simple function
    private List<String> buildBoard(char[][] board) {
        List<String> currentBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            currentBoard.add(new String(board[i]));
        }
        return currentBoard;
    }
}
