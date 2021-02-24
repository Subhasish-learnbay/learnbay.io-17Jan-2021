package linkedlist.assignment2;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	public Node copyRandomList(Node head) {
		Map<Node, Node> map = new HashMap<>();
		Node resHead = null, resTail = null;
		Node temp = head;
		while (temp != null) {
			if (resHead == null) {
				resHead = new Node(temp.val);
				map.put(temp, resHead);
				resTail = resHead;
			} else {
				Node node = new Node(temp.val);
				resTail.next = node;
				map.put(temp, node);
				resTail = resTail.next;
			}
			temp = temp.next;
		}
		temp = head;
		while (temp != null) {
			map.get(temp).random = map.get(temp.random);
			temp = temp.next;
		}
		return resHead;
	}
}
