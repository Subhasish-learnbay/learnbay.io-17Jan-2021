package tree.assignment1;

public class Diameter {
	class Return {
		int dia;
		int height;
	}

	public int diameterOfBinaryTree(TreeNode root) {

		return diameterOfBinaryTreeUtil(root).dia;
	}

	public Return diameterOfBinaryTreeUtil(TreeNode root) {
		Return res = new Return();
		if (root == null) {
			return res;
		}
		Return leftRes = diameterOfBinaryTreeUtil(root.left);
		Return rightRes = diameterOfBinaryTreeUtil(root.right);
		res.dia = Math.max(Math.max(leftRes.dia, rightRes.dia), leftRes.height + rightRes.height);
		res.height = Math.max(leftRes.height, rightRes.height) + 1;
		return res;
	}
}
