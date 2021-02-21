package array.assignment1;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		res[0] = 1;
		for (int i = 1; i < nums.length; i++)
			res[i] = res[i - 1] * nums[i - 1];

		int val = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			val *= nums[i + 1];
			res[i] *= val;
		}

		return res;
	}
}
