package tree.assignment1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		int level = 0;
		while (!queue.isEmpty()) {
			TreeNode node;
			if (level % 2 == 0) {
				node = queue.poll();
			} else {
				node = queue.pollLast();
			}
			if (node == null) {
				level++;
				if (!queue.isEmpty()) {
					if (level % 2 == 0) {
						queue.add(null);
					} else {
						queue.addFirst(null);
					}
				}
				result.add(res);
				res = new ArrayList<>();
				continue;
			}
			res.add(node.val);
			if (level % 2 == 0) {
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			} else {
				if (node.right != null)
					queue.addFirst(node.right);
				if (node.left != null)
					queue.addFirst(node.left);

			}

		}
		return result;
	}
}
