class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // Base case: 2 points always form a straight line
        if (coordinates.length <= 2) {
            return true;
        }
        
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        
        int dx = x1 - x0;
        int dy = y1 - y0;
        
        // Check if all subsequent points maintain the same slope
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            
            if (dy * (x - x0) != (y - y0) * dx) {
                return false;
            }
        }
        
        return true;
    }
}
