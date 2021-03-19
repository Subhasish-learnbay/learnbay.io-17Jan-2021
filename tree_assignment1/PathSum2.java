package tree.assignment1;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> paths = new ArrayList<>();

		if (root == null) {
			return paths;
		}

		if (root.val == targetSum && root.left == null && root.right == null) {
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			paths.add(list);
			return paths;
		}

		List<Integer> list = new ArrayList<>();
		list.add(root.val);

		List<List<Integer>> leftPaths = pathSum(root.left, targetSum - root.val);
		List<List<Integer>> rightPaths = pathSum(root.right, targetSum - root.val);
		for (List<Integer> leftpath : leftPaths) {
			leftpath.add(0, root.val);
			paths.add(leftpath);
		}
		for (List<Integer> rightPath : rightPaths) {
			rightPath.add(0, root.val);
			paths.add(rightPath);
		}
		return paths;
	}
}
