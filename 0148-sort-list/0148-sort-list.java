class Solution {
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergeLists(ListNode list1, ListNode list2) {
        if(list1==null) {
            return list2;
        }
        if(list2==null) {
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while(temp1!=null && temp2!=null) {
            if(temp1.val<=temp2.val) {
                tail.next = temp1;
                tail = temp1;
                temp1 = temp1.next;
            }
            else {
                tail.next = temp2;
                tail = temp2;
                temp2 = temp2.next;
            }
        }
        if(temp1!=null) {
            tail.next = temp1;
        }
        if(temp2!=null) {
            tail.next = temp2;
        }
        return head.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode midNode = findMid(head);
        ListNode right = midNode.next;
        ListNode left = head;
        midNode.next = null;
        left = sortList(left);
        right = sortList(right);
        return mergeLists(left, right);
    }
}