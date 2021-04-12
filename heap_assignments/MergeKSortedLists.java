package heap.assignment1;

import java.util.PriorityQueue;

import linkedlist.assignment1.ListNode;

public class MergeKSortedLists {
	class Pair implements Comparable<Pair> {
		int val, i;
		ListNode node;

		Pair(int val, int i, ListNode node) {
			this.val = val;
			this.i = i;
			this.node = node;

		}

		public int compareTo(Pair p) {
			return this.val - p.val;
		}

	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode res = null;
		ListNode end = null;
		PriorityQueue<Pair> minHeap = new PriorityQueue<>();
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				minHeap.add(new Pair(lists[i].val, i, lists[i]));
		}
		while (!minHeap.isEmpty()) {
			Pair p = minHeap.poll();
			if (res == null) {
				res = p.node;
				end = p.node;
			} else {
				end.next = p.node;
				end = end.next;
			}
			lists[p.i] = lists[p.i].next;
			if (lists[p.i] != null)
				minHeap.add(new Pair(lists[p.i].val, p.i, lists[p.i]));
		}
		return res;
	}
}
