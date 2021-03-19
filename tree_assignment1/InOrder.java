package tree.assignment1;

import java.util.ArrayList;
import java.util.List;

public class InOrder {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		List<Integer> left = inorderTraversal(root.left);
		List<Integer> right = inorderTraversal(root.right);
		res.addAll(left);
		res.add(root.val);
		res.addAll(right);
		return res;
	}
}
