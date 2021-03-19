package tree.assignment1;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {
	public int sumNumbers(TreeNode root) {
		int sum = 0;
		List<String> res = sumNumbersUtil(root);
		for (String num : res)
			sum += Integer.parseInt(num);
		return sum;
	}

	public List<String> sumNumbersUtil(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null)
			return res;
		if (root.left == null && root.right == null) {
			res.add(root.val + "");
			return res;
		}
		List<String> leftRes = sumNumbersUtil(root.left);
		List<String> rightRes = sumNumbersUtil(root.right);
		for (String num : leftRes) {
			res.add(root.val + num);
		}
		for (String num : rightRes) {
			res.add(root.val + num);
		}
		return res;
	}

	static int count(String num) {
		return num.length();
	}
}
