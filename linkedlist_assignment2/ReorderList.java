package linkedlist.assignment2;

import java.util.Stack;

public class ReorderList {

	public void reorderList(ListNode head) {
		if (head == null)
			return;
		Stack<ListNode> stack = new Stack<>();
		ListNode temp = head;
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null && fast.next == null)
			slow = slow.next;
		while (slow != null) {
			stack.push(slow);
			slow = slow.next;
		}
		temp = head;
		while (!stack.isEmpty()) {
			ListNode next = temp.next;
			ListNode pop = stack.pop();
			temp.next = pop;
			pop.next = next;
			temp = next;
		}
		temp.next = null;
	}
}
