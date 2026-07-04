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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode afterMid = reverseList(slow.next);
        int maxSum = Integer.MIN_VALUE;
        while(afterMid!=null) {
            int sum = head.val+afterMid.val;
            if(sum>maxSum) {
                maxSum = sum;
            }
            head = head.next;
            afterMid = afterMid.next;
        }
        return maxSum;
    }
}