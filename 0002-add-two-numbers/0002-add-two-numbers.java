class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return buildSumList(l1, l2);
    }

    private ListNode buildSumList(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = getNodeValue(l1) + getNodeValue(l2) + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            l1 = getNextNode(l1);
            l2 = getNextNode(l2);
        }

        return dummyHead.next;
    }

    private int getNodeValue(ListNode node) {
        return (node != null) ? node.val : 0;
    }

    private ListNode getNextNode(ListNode node) {
        return (node != null) ? node.next : null;
    }
}