package tree.assignment1;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		List<Integer> left = postorderTraversal(root.left);
		List<Integer> right = postorderTraversal(root.right);
		res.addAll(left);
		res.addAll(right);
		res.add(root.val);
		return res;
	}
}
