package tree.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {
	int min = 0, max = 0;

	public List<List<Integer>> verticalTraversal(TreeNode root) {

		Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
		inOrder(root, 0, 0, map);
		List<List<Integer>> result = new ArrayList<>();

		for (int i = min; i <= max; i++) {
			List<Integer> res = new ArrayList<>();
			// Collections.sort(map.get(i));
			// res.add(map.get(i));
			Map<Integer, List<Integer>> m = map.get(i);
			for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
				List<Integer> li = entry.getValue();
				Collections.sort(li);
				res.addAll(li);
			}
			result.add(res);
		}
		return result;
	}

	void inOrder(TreeNode root, int level, int hd, Map<Integer, Map<Integer, List<Integer>>> map) {
		if (root == null)
			return;
		inOrder(root.left, level + 1, hd - 1, map);
		if (!map.containsKey(hd)) {
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			Map<Integer, List<Integer>> m = new TreeMap<>();
			m.put(level, list);
			map.put(hd, m);
			max = Math.max(max, hd);
			min = Math.min(min, hd);
		} else {
			if (map.get(hd).containsKey(level))
				map.get(hd).get(level).add(root.val);
			else {
				List<Integer> list = new ArrayList<>();
				list.add(root.val);
				map.get(hd).put(level, list);

			}
		}
		inOrder(root.right, level + 1, hd + 1, map);
	}
}
