package listnode;

import org.junit.Test;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class No21MergeTwoSortedLists {
    /**
     * 迭代
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return mergeTwoLists2(l1, l2);
    }

    private ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
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

    private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    @Test
    public void testCase1() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode node = mergeTwoLists(l1, l2);
        System.out.println(node);
    }

    @Test
    public void testCase2() {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);

        ListNode node = mergeTwoLists(l1, l2);
        System.out.println(node);
    }
}
