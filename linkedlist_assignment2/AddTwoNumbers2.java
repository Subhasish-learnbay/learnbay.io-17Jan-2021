package linkedlist.assignment2;

public class AddTwoNumbers2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1 = reverse(l1);
		l2 = reverse(l2);
		ListNode l3 = addTwoNumbers1(l1, l2);
		l3 = reverse(l3);
		return l3;
	}

	public static ListNode reverse(ListNode head) {
		ListNode prev = null, current = head, next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public static ListNode addTwoNumbers1(ListNode head1, ListNode head2) {
		ListNode resHead = null, resTail = null;
		int carry = 0, value = 0;
		while (head1 != null || head2 != null) {
			int sum = 0;
			if (head1 != null)
				sum += head1.val;
			if (head2 != null)
				sum += head2.val;
			sum += carry;
			carry = sum / 10;
			value = sum % 10;
			if (resHead == null) {
				resHead = new ListNode(value);
				resTail = resHead;
			} else {
				resTail.next = new ListNode(value);
				resTail = resTail.next;
			}
			if (head1 != null)
				head1 = head1.next;
			if (head2 != null)
				head2 = head2.next;
		}
		if (carry == 1) {
			resTail.next = new ListNode(1);
			resTail = resTail.next;
		}
		return resHead;
	}
}
