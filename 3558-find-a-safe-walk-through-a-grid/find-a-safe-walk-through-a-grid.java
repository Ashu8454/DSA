import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, health - grid.get(0).get(0)});
        
        int[][] maxHealth = new int[m][n];
        for (int[] row : maxHealth) {
            Arrays.fill(row, -1);
        }
        maxHealth[0][0] = health - grid.get(0).get(0);
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int h = current[2];
            
            if (h < 1) {
                continue;
            }
            
            if (r == m - 1 && c == n - 1) {
                return true;
            }
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextHealth = h - grid.get(nr).get(nc);
                    
                    if (nextHealth >= 1 && nextHealth > maxHealth[nr][nc]) {
                        maxHealth[nr][nc] = nextHealth;
                        queue.add(new int[]{nr, nc, nextHealth});
                    }
                }
            }
        }
        
        return false;
    }
}
