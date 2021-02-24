package linkedlist.assignment2;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedList2 {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode temp = head;
		Set<Integer> duplicates = new HashSet<>();
		while (temp.next != null) {
			if (temp.val == temp.next.val) {
				duplicates.add(temp.val);
			}
			temp = temp.next;
		}
		temp = head;
		while (temp.next != null) {
			if (duplicates.contains(temp.next.val)) {
				int val = temp.next.val;
				ListNode ref = temp.next;
				while (ref != null && ref.val == val)
					ref = ref.next;
				temp.next = ref;
			} else {
				temp = temp.next;
			}
		}
		if (duplicates.contains(head.val))
			head = head.next;
		return head;
	}
}
