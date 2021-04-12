package heap.assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
	class Pair implements Comparable<Pair> {
		int u, v, sum;

		Pair(int u, int v, int sum) {
			this.u = u;
			this.v = v;
			this.sum = sum;
		}

		public int compareTo(Pair p) {
			return this.sum - p.sum;
		}

	}

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<Pair> minHeap = new PriorityQueue<>();
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				minHeap.add(new Pair(nums1[i], nums2[j], nums1[i] + nums2[j]));
			}
		}
		List<List<Integer>> res = new ArrayList<>();
		while (k-- > 0) {
			Pair p = minHeap.poll();
			if (p == null)
				return res;
			List<Integer> l = new ArrayList<>();
			l.add(p.u);
			l.add(p.v);
			res.add(l);
		}
		return res;
	}
}
