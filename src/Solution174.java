public class Solution174 {
	public int calculateMinimumHP(int[][] dungeon) {
		int n = dungeon.length;
		int m = dungeon[0].length;

		dungeon[n - 1][m - 1] = Math.max(1 - dungeon[n - 1][m - 1], 1);

		for (int i = n - 2; i >= 0; i--) {
			dungeon[i][m - 1] = Math.max(dungeon[i + 1][m - 1] - dungeon[i][m - 1], 1);
		}

		for (int j = m - 2; j >= 0; j--) {
			dungeon[n - 1][j] = Math.max(dungeon[n - 1][j + 1] - dungeon[n - 1][j], 1);
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = m - 2; j >= 0; j--) {
				dungeon[i][j] = Math.max(Math.min(dungeon[i + 1][j], dungeon[i][j + 1])
						- dungeon[i][j], 1);
			}
		}
		return dungeon[0][0];
	}
}