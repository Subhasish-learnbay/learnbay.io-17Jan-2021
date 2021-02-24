package linkedlist.assignment2;

import linkedlist.assignment2.ListNode;

public class ReverseLinkedListKGroups {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		// head.next.next.next.next.next.next.next.next = new ListNode(9);

		head = reverseKGroup(head, 3);
		System.out.println("done");
	}

	static boolean hasKNodes(ListNode node, int K) {
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
			if (count == K)
				return true;
		}
		return false;
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode prev = null;
		ListNode current = head;
		ListNode next = null;
		int count = 0;
		ListNode resH = null, resT = current, resNextT = null;
		boolean flag = false;
		while (current != null) {
			if (count == k) {
				count = 0;
				if (flag == false) {
					resH = prev;
					resNextT = current;
					flag = true;
				} else {
					resT.next = prev;
					resT = resNextT;
					resNextT = current;
				}
				if (!hasKNodes(current, k)) {
					resT.next = current;
					return resH;
				}
			}
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if (count == k) {
			count = 0;
			if (flag == false) {
				resH = prev;
				resNextT = current;
				flag = true;
			} else {
				resT.next = prev;
				resT = resNextT;
				resNextT = current;
			}
		} else {

		}

		resT.next = null;
		return resH;
	}
}
