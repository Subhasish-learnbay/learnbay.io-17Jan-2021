package array.assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfArray {

	public int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (countMap.containsKey(nums[i])) {
				countMap.put(nums[i], countMap.get(nums[i]) + 1);
			} else {
				countMap.put(nums[i], 1);
			}
		}

		int max = -1;
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > max)
				max = entry.getValue();
		}

		List<Integer> elements = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() == max)
				elements.add(entry.getKey());
		}
		int res = Integer.MAX_VALUE;

		for (int element : elements) {
			int i, j;
			for (i = 0; i < nums.length; i++) {
				if (nums[i] == element)
					break;
			}
			for (j = nums.length - 1; j >= 0; j--) {
				if (nums[j] == element)
					break;
			}
			res = Math.min(res, j - i + 1);
		}
		return res;
	}
}
