package heap.assignment1;

import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestPointsToOrigin {
	class Point implements Comparable<Point> {
		int x, y;
		double d;

		Point(int x, int y, double d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		public int compareTo(Point point) {
			if (this.d - point.d > 0)
				return 1;
			else if (this.d - point.d < 0)
				return -1;
			else
				return 0;
		}
	}

	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Point> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int count = 0;
		int i;
		for (i = 0; i < points.length; i++) {
			if (count == k)
				break;
			double di = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
			maxHeap.add(new Point(points[i][0], points[i][1], di));
			count++;
		}
		for (int j = i; j < points.length; j++) {
			double d = Math.sqrt(points[j][0] * points[j][0] + points[j][1] * points[j][1]);
			if (d < maxHeap.peek().d) {
				maxHeap.poll();
				maxHeap.add(new Point(points[j][0], points[j][1], d));
			}
		}

		int[][] res = new int[k][2];
		int x = 0;
		while (!maxHeap.isEmpty()) {
			Point p = maxHeap.poll();
			res[x][0] = p.x;
			res[x][1] = p.y;
			x++;
		}
		return res;
	}
}
