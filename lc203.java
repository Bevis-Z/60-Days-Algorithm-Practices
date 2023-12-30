
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead;
        ListNode cur = head;
        while( cur!= null ) {
            if(cur.val == val) {
                pre.next = cur.next;
            } else {
                pre =cur;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}