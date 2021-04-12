package heap.assignment1;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMaximumNumber {
	public int thirdMax(int[] nums) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		Set<Integer> set = new HashSet<>();
		int size = 0;
		int i;
		for (i = 0; i < nums.length; i++) {
			if (size == 3)
				break;
			if (!set.contains(nums[i])) {
				minHeap.add(nums[i]);
				set.add(nums[i]);
				size++;
			}
		}
		for (int j = i; j < nums.length; j++) {
			if (nums[j] > minHeap.peek()) {
				if (!set.contains(nums[j])) {
					minHeap.poll();
					minHeap.add(nums[j]);
					set.add(nums[j]);
				}

			}
		}
		if (minHeap.size() == 3)
			return minHeap.peek();
		else {
			while (minHeap.size() != 1)
				minHeap.poll();
			return minHeap.peek();
		}
	}
}
