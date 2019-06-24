package listnode;

import org.junit.Test;

public class No23MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists1(lists);
    }

    /**
     * 暴力法，将链表数组进行两两合并。
     */
    private ListNode mergeKLists1(ListNode[] lists) {
        ListNode dummyNode = null;
        for (ListNode list : lists) {
            dummyNode = mergeTwoLists(dummyNode, list);
        }

        return dummyNode;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                dummyNode.next = new ListNode(l2.val);
                dummyNode = dummyNode.next;
                l2 = l2.next;
            } else if (l2 == null) {
                dummyNode.next = new ListNode(l1.val);
                dummyNode = dummyNode.next;
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                dummyNode.next = new ListNode(l1.val);
                dummyNode = dummyNode.next;
                l1 = l1.next;
            } else {
                dummyNode.next = new ListNode(l2.val);
                dummyNode = dummyNode.next;
                l2 = l2.next;
            }
        }

        return head.next;
    }

    @Test
    public void testCase1() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] listNodes = new ListNode[]{l1, l2, l3};

        ListNode node = mergeKLists(listNodes);
        System.out.println(node);

    }
}
