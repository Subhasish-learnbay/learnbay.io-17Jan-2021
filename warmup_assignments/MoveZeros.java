package warmup_sessions.set1;

public class MoveZeros {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 3, 12 };
		moveZeroes(arr);
		for(int val : arr)
			System.out.print(val+" ");
	}

	static void moveZeroes(int[] nums) {
		int i = 0, j = 0;
		while (j < nums.length) {
			if (nums[j] != 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j++;
			} else {
				j++;
			}
		}
	}
}
