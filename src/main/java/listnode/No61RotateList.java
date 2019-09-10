package listnode;

import org.junit.Test;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class No61RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null ||head.next == null){
            return head;
        }

        int size = 0;

        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }

        // 将单链表首尾相连
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;

        for (int times = size - k; times > 0; times--) {
            head = head.next;
        }
        return head;
    }

    @Test
    public void testCase1() {
        /*
            输入: 1->2->3->4->5->NULL, k = 2
            输出: 4->5->1->2->3->NULL
            解释:
            向右旋转 1 步: 5->1->2->3->4->NULL
            向右旋转 2 步: 4->5->1->2->3->NULL
         */

        ListNode listNode = ListNode.of("1,2,3,4,5");
        ListNode rotateRight = rotateRight(listNode, 2);
        System.out.println(rotateRight);

    }
}
