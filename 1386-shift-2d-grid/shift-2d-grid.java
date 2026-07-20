class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int totalElements = m * n;
        k = k % totalElements;
        
        // Initialize 2D array to hold shifted values
        int[][] resArray = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int flatIndex = i * n + j;
                int newFlatIndex = (flatIndex + k) % totalElements;
                
                int newRow = newFlatIndex / n;
                int newCol = newFlatIndex % n;
                
                resArray[newRow][newCol] = grid[i][j];
            }
        }
        
        // Convert to required List<List<Integer>> format
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : resArray) {
            List<Integer> listRow = new ArrayList<>();
            for (int val : row) {
                listRow.add(val);
            }
            result.add(listRow);
        }
        return result;
    }
}
