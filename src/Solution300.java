import static java.util.Arrays.binarySearch;

public class Solution300 {
	public int lengthOfLIS(int[] nums) {
		int l = nums.length;
		int[] f = new int[l];
		int count = 0;
		for (int i = 0; i < l; i++) {

			int t = binarySearch(f, 0, count, nums[i]);

			if (t < 0) {
				int index = ~t;
				f[index] = nums[i];
				if (index == count)
					count++;
			}
		}
		return count;
	}
}