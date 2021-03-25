package bst.assignment1;

import java.util.ArrayList;
import java.util.List;

public class RecoverBST {
	class Pair {
		TreeNode prev;
		TreeNode next;

		Pair(TreeNode prev, TreeNode next) {
			this.prev = prev;
			this.next = next;
		}
	}

	public void recoverTree(TreeNode root) {
		List<TreeNode> inorder = new ArrayList<>();
		inOrder(root, inorder);
		int count = 0;
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < inorder.size() - 1; i++) {
			if (inorder.get(i + 1).val < inorder.get(i).val) {
				count++;
				list.add(new Pair(inorder.get(i), inorder.get(i + 1)));
			}
		}
		if (count == 1) {
			Pair pair = list.get(0);
			int temp = pair.prev.val;
			pair.prev.val = pair.next.val;
			pair.next.val = temp;
		} else {
			Pair pair1 = list.get(0);
			Pair pair2 = list.get(1);
			int temp = pair1.prev.val;
			pair1.prev.val = pair2.next.val;
			pair2.next.val = temp;
		}
	}

	void inOrder(TreeNode root, List<TreeNode> inorder) {
		if (root == null)
			return;
		inOrder(root.left, inorder);
		inorder.add(root);
		inOrder(root.right, inorder);
	}
}
