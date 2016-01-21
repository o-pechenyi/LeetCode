public class Solution213 {
	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		return Math.max(robInRange(nums, 0, nums.length - 1),
				robInRange(nums, 1, nums.length));
	}

	public int robInRange(int[] nums, int start, int end) {
		int f = 0, g = 0;
		for (int i = start; i < end; i++) {
			int t = Math.max(f, g);
			f = nums[i] + g;
			g = t;
		}

		return Math.max(f, g);
	}
}