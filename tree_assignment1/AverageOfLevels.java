package tree.assignment1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		double sum = 0;
		int count = 0;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				res.add(sum / count);
				sum = 0;
				count = 0;
				if (!queue.isEmpty()) {
					queue.add(null);
				}
				continue;
			}
			sum += node.val;
			count++;
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		return res;
	}
}
