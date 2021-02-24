package linkedlist.assignment2;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int countA = 0, countB = 0;
		ListNode tempA = headA, tempB = headB;
		while (tempA != null) {
			countA++;
			tempA = tempA.next;
		}
		while (tempB != null) {
			countB++;
			tempB = tempB.next;
		}
		if (countA > countB) {
			int count = countA - countB;
			while (count-- > 0) {
				headA = headA.next;
			}
		} else if (countB > countA) {
			int count = countB - countA;
			while (count-- > 0) {
				headB = headB.next;
			}
		}
		while (headA != headB) {
			if (headA == null)
				return null;
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}
}
