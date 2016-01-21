public class Solution198 {
	public int rob(int[] nums) {
		int f = 0, g = 0;
		for (int i = 0; i < nums.length; i++) {
			int t = Math.max(f, g);
			f = nums[i] + g;
			g = t;
		}

		return Math.max(f, g);
	}
}