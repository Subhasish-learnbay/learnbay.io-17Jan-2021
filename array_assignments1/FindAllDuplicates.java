package array.assignment1;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int[] count = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			if (count[nums[i]] != 0) {
				res.add(nums[i]);
			}
			count[nums[i]] += 1;
		}
		return res;
	}
}
