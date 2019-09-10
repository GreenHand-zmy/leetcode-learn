package listnode;

import org.junit.Test;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class No148SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 第一步将链表一分为二
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // 第二步将左右链表排序
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // 第三步合并链表
        return merge(l1, l2);
    }


    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode root = dummyNode;

        // 此while循环可以优化
        /*while (l1 != null || l2 != null) {
            if (l1 == null) {
                root.next = l2;
                root = root.next;
                l2 = l2.next;
            } else if (l2 == null) {
                root.next = l1;
                root = root.next;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                root.next = l1;
                root = root.next;
                l1 = l1.next;
            } else {
                root.next = l2;
                root = root.next;
                l2 = l2.next;
            }
        }*/

        // 利用链表可以直接接上的性质，当某列表元素比较并选择完毕后，可以直接把另一个列表直接连接在末尾。
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                root.next = l1;
                root = root.next;
                l1 = l1.next;
            } else {
                root.next = l2;
                root = root.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            root.next = l2;
        }

        if (l2 == null) {
            root.next = l1;
        }

        return dummyNode.next;
    }

    @Test
    public void testCase1() {
        /*ListNode listNode1 = ListNode.of("3,4");
        ListNode listNode2 = ListNode.of("1,2");
        System.out.println("listNode1：" + listNode1);
        System.out.println("listNode2：" + listNode2);
        System.out.println(merge(listNode1, listNode2));*/

        ListNode listNode = ListNode.of("4,2,1,3");
        System.out.println(sortList(listNode));

    }
}
