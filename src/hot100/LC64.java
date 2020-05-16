package hot100;

/**
 * Created by W
 * Date: 2020-05-16 22:14
 * Description
 */
public class LC64 {

    public int minPathSum(int[][] grid) {
        //动态规划
        int m = grid.length - 1;
        int n = grid[0].length - 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        return grid[m][n];
    }
}


