public class Solution064 {
	public int minPathSum(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		for (int i = n - 2; i >= 0; i--) {
			grid[i][m - 1] += grid[i + 1][m - 1];
		}

		for (int j = m - 2; j >= 0; j--) {
			grid[n - 1][j] += grid[n - 1][j + 1];
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = m - 2; j >= 0; j--) {
				grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
			}
		}
		return grid[0][0];
	}

}