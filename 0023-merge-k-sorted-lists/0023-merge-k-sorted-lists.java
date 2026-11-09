class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for(ListNode node: lists) {
            if(node!=null) {
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            temp.next = min;
            if(min.next!=null) {
                pq.offer(min.next);
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}