package listnode;

import org.junit.Test;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class No82RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        for (ListNode curX = head; curX != null; curX = curX.next) {
            prev = curX;

            for (ListNode curY = curX.next; curY != null; curY = curY.next) {
                if (curX.val != curY.val){
                    break;
                }
            }
        }

        return null;
    }

    @Test
    public void testCase1() {
        /*
         * 输入: 1->2->3->3->4->4->5
         * 输出: 1->2->5
         */
        ListNode listNode = ListNode.of("1,2,3,3,4,4,5");
        ListNode duplicates = deleteDuplicates(listNode);
        System.out.println(duplicates);
    }
}
