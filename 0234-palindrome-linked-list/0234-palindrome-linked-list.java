class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode afterMid = reverseList(slow.next);
        while(afterMid!=null) {
            if(head.val!=afterMid.val) {
                return false;
            }
            head = head.next;
            afterMid = afterMid.next;
        }
        return true;
    }
}