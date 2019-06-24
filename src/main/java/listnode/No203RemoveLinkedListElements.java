package listnode;

import org.junit.Test;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class No203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        return removeElements2(head, val);
    }

    /**
     * 遍历法，在遍历的同时记下前置节点，这样子容易做删除。
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    private ListNode removeElements1(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        ListNode cur = head;

        while (cur != null) {

            if (cur.val == val) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return dummyNode.next;
    }

    /**
     * 递归法，一直递归到链表末尾，在栈返程的时候判断是否和值相同，如果相同返回下一个节点。
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    private ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElements2(head.next, val);

        if (head.val == val) {
            return head.next;
        }
        return head;
    }


    @Test
    public void testCase1() {
        //1->2->6->3->4->5->6, val = 6
        ListNode listNode = ListNode.of("1,2,6,3,4,5,6");
        ListNode result = removeElements(listNode, 6);
        System.out.println(result);
    }

    @Test
    public void testCase2() {
        //1->2->6->3->4->5->6, val = 6
        ListNode listNode = ListNode.of("1,1");
        ListNode result = removeElements(listNode, 1);
        System.out.println(result);
    }
}
