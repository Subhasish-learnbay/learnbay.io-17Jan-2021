package heap.assignment1;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int w : stones)
			maxHeap.add(w);
		while (maxHeap.size() > 1) {
			int w1 = maxHeap.poll();
			int w2 = maxHeap.poll();
			int res = Math.abs(w1 - w2);
			if (res != 0)
				maxHeap.add(res);
		}
		if (!maxHeap.isEmpty())
			return maxHeap.peek();
		else
			return 0;
	}
}
