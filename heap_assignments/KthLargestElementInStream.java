package heap.assignment1;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
	PriorityQueue<Integer> minHeap;
	int k;

	public KthLargestElementInStream(int k, int[] nums) {
		this.k = k;
		minHeap = new PriorityQueue<>();
		if (nums.length < k) {
			for (int e : nums)
				minHeap.add(e);
		} else {
			for (int i = 0; i < k; i++)
				minHeap.add(nums[i]);
			for (int i = k; i < nums.length; i++) {
				if (nums[i] > minHeap.peek()) {
					minHeap.poll();
					minHeap.add(nums[i]);
				}
			}
		}
	}

	public int add(int val) {
		if (minHeap.size() < k) {
			minHeap.add(val);
			return minHeap.peek();
		}
		if (val > minHeap.peek()) {
			minHeap.poll();
			minHeap.add(val);
		}
		return minHeap.peek();
	}
}
