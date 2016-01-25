/*
Counting minimal lost of HP (If we get HP insted of lost - it meanth we don't lost HP - so, lost of HP is 0)
In the end we have minimal lost HP in the dungeon[0][0] cell (negative value or 0), so we must get -dungeon[0][0] and 
add 1 (because knight can't have zero HP)...
*/
public class Solution174 {
  public int calculateMinimumHP(int[][] dungeon) {
    int lastI = dungeon.length - 1;
    int lastJ = dungeon[0].length - 1;
    int preLastI = lastI - 1;
    int preLastJ = lastJ - 1;
    
    dungeon[lastI][lastJ] = Math.min(dungeon[lastI][lastJ], 0);
    for (int i = preLastI; i >= 0; i--) {
      dungeon[i][lastJ] += dungeon[i+1][lastJ];
      dungeon[i][lastJ] = dungeon[i][lastJ] < 0 ? dungeon[i][lastJ] : 0;
    }
    for (int j = preLastJ; j >= 0; j--) {
      dungeon[lastI][j] = Math.min(dungeon[lastI][j] + dungeon[lastI][j+1], 0);
    }
    for (int i = preLastI; i >= 0; i--) {
      for (int j = preLastJ; j >= 0; j--) {
        dungeon[i][j] = Math.min(dungeon[i][j] + Math.max(dungeon[i+1][j], dungeon[i][j+1]), 0);
      }
    }
    return -dungeon[0][0] + 1;
  }
}
