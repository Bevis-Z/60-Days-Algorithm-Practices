/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> nodeSeen = new HashSet<>();

        ListNode resultNode = head;
        while (resultNode != null) {
            if (nodeSeen.contains(resultNode)) {
                return resultNode;
            } else {
                nodeSeen.add(resultNode);
                resultNode = resultNode.next;
            }
        }

        return null;
    }
}