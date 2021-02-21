package array.assignment1;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		if (nums.length == 1)
			return;
		int n = nums.length;
		k = k % n;
		reverse(nums, 0, n - k - 1);
		reverse(nums, n - k, n - 1);
		reverse(nums, 0, n - 1);
	}

	public void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
}
