package array.assignment1;

import java.util.Arrays;

public class Closest3Sum {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closestSum = Integer.MAX_VALUE, closestDiff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int ptr1 = i + 1, ptr2 = nums.length - 1;
			while (ptr1 < ptr2) {
				int sum = nums[i] + nums[ptr1] + nums[ptr2];
				int diff = Math.abs(sum - target);
				if (diff < closestDiff) {
					closestDiff = diff;
					closestSum = sum;
				}
				if (sum < target)
					ptr1++;
				else
					ptr2--;

			}
		}
		return closestSum;
	}
}
