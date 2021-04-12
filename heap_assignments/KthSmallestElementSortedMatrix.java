package heap.assignment1;

import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {
	class Element implements Comparable<Element> {
		int i, j, val;

		Element(int i, int j, int val) {
			this.i = i;
			this.j = j;
			this.val = val;
		}

		public int compareTo(Element e) {
			return this.val - e.val;
		}

	}

	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Element> minHeap = new PriorityQueue<>();
		boolean[][] repeat = new boolean[matrix.length][matrix.length];
		minHeap.add(new Element(0, 0, matrix[0][0]));
		repeat[0][0] = true;
		int count = 0;
		while (!minHeap.isEmpty()) {
			Element e = minHeap.poll();
			count++;
			if (count == k)
				return e.val;
			if (e.i < n && e.j + 1 < n && !repeat[e.i][e.j + 1]) {
				minHeap.add(new Element(e.i, e.j + 1, matrix[e.i][e.j + 1]));
				repeat[e.i][e.j + 1] = true;
			}
			if (e.i + 1 < n && e.j + 1 < n && !repeat[e.i + 1][e.j]) {
				minHeap.add(new Element(e.i + 1, e.j, matrix[e.i + 1][e.j]));
				repeat[e.i + 1][e.j] = true;
			}
		}
		return -1;
	}
}
