package linkedlist.assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RemoveZeroSumConsecutiveNodes {
	public static ListNode removeZeroSumSublists(ListNode head) {
		List<Integer> list = new ArrayList<>();
		ListNode temp = head;
		while (temp != null) {
			list.add(temp.val);
			temp = temp.next;
		}
		Set<Integer> removeIndex = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			if (sum == 0) {
				for (int j = 0; j <= i; j++)
					removeIndex.add(j);
				map.clear();
				continue;
			}
			if (map.containsKey(sum)) {
				for (int j = map.get(sum) + 1; j <= i; j++)
					removeIndex.add(j);
				List<Integer> removeMap = new ArrayList<>();
				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					if (entry.getValue() >= map.get(sum) + 1 && entry.getValue() <= i)
						removeMap.add(entry.getKey());
				}
				for (int k : removeMap)
					map.remove(k);
				continue;
			}
			map.put(sum, i);
		}

		ListNode res = null;
		ListNode resHead = null;
		for (int i = 0; i < list.size(); i++) {
			if (removeIndex.contains(i))
				continue;
			if (res == null) {
				res = new ListNode(list.get(i));
				resHead = res;
			} else {
				res.next = new ListNode(list.get(i));
				res = res.next;
			}

		}
		return resHead;
	}

}
