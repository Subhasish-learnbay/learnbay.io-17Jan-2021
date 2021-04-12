package heap.assignment1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	class Pair implements Comparable<Pair> {
		int key, val;

		Pair(int key, int val) {
			this.key = key;
			this.val = val;
		}

		public int compareTo(Pair pair) {
			if (this.val > pair.val)
				return 1;
			else if (this.val < pair.val)
				return -1;
			else
				return 0;
		}
	}

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> freq = new HashMap<>();
		for (int val : nums) {
			if (!freq.containsKey(val))
				freq.put(val, 1);
			else
				freq.put(val, freq.get(val) + 1);
		}
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
		}
		int[] res = new int[k];
		int c = 0;
		while (k-- > 0) {
			Pair pair = maxHeap.poll();
			res[c++] = pair.key;
		}
		return res;
	}
}
