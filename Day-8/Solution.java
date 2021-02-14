import java.util.Comparator;
import java.util.PriorityQueue;

/*
Singly Linked List

*/

class ListNode {
    // Members of the class are:
    int val; // station number
    ListNode next; // next station
}

class Solution {
    // Implement mergeKLists method
    public ListNode mergeKTracks(ListNode[] tracks) {
        ListNode result = null;
        ListNode curr = null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            };
        });

        for (ListNode node : tracks) {
            minHeap.offer(node);
        }

        ListNode next;
        while (!minHeap.isEmpty()) {
            next = minHeap.poll();

            if (result == null) {
                result = curr = next;
            } else {
                curr.next = next;
                curr = curr.next;
            }

            if (next.next != null)
                minHeap.offer(next.next);
        }

        return result;
    }
}
