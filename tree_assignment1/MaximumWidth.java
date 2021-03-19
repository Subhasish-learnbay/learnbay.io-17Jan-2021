package tree.assignment1;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumWidth {
	public int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int ans = 1;
		while (!queue.isEmpty()) {
			trimQueue(queue);
			ans = Math.max(ans, queue.size());
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node == null) {
					queue.add(null);
					queue.add(null);
				} else {
					queue.add(node.left);
					queue.add(node.right);
				}
			}
		}
		return ans;
	}

	void trimQueue(Deque<TreeNode> queue) {
		while (!queue.isEmpty() && queue.peekFirst() == null)
			queue.poll();
		while (!queue.isEmpty() && queue.peekLast() == null)
			queue.pollLast();
	}
}
