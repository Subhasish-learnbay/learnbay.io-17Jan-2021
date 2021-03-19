package tree.assignment1;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}

public class PopulatingNextRightPointers1 {
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
