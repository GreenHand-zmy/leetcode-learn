package listnode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class No206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return reverseList3(head);
    }

    /**
     * 迭代法，遍历一遍链表，将元素都保存到数组中再逆序遍历数组，将元素保存到新链表中。
     * 这应该是最容易想到的方法。
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public ListNode reverseList1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            list.add(cur.val);
        }

        ListNode result = new ListNode(0);
        ListNode temp = result;
        for (int i = list.size() - 1; i >= 0; i--) {
            Integer val = list.get(i);

            temp.next = new ListNode(val);
            temp = temp.next;
        }

        return result.next;
    }

    /**
     * 迭代法，遍历一遍链表，将当前节点的next指针变为上一个节点。
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextTemp;
        }

        return prev;
    }

    /**
     * 递归版本，一直递归到结尾，返回尾节点，然后在将链表翻转。
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


    @Test
    public void testCase1() {
        ListNode listNode = ListNode.of("1,2,3,4,5");
        ListNode reverseList = reverseList(listNode);

        System.out.println(reverseList);
    }
}
