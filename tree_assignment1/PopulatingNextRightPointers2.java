package tree.assignment1;

import java.util.LinkedList;
import java.util.Queue;


public class PopulatingNextRightPointers2 {
	public Node connect(Node root) {
		if (root == null)
			return null;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node == null) {
				if (!queue.isEmpty())
					queue.add(null);
				continue;
			}
			node.next = queue.peek();
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		return root;
	}
}
