package heap.assignment1;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		int i;
		for (i = 0; i < k; i++)
			minHeap.add(nums[i]);
		for (int j = i; j < nums.length; j++) {
			if (nums[j] >= minHeap.peek()) {
				minHeap.poll();
				minHeap.add(nums[j]);
			}
		}
		return minHeap.peek();
	}
}
