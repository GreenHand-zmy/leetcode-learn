package listnode;

import org.junit.Test;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的深拷贝。
 */
public class No138CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node copy = new Node();
        copyNext(copy, head);
        copyRandom(copy.next, head);
        System.out.println();
        return null;
    }

    private void copyNext(Node copy, Node origin) {
        Node originCur = origin, copyCur = copy;
        while (originCur != null) {
            copyCur.next = new Node(originCur.val, null, null);
            copyCur = copyCur.next;

            originCur = originCur.next;
        }
    }

    private void copyRandom(Node copy, Node origin) {
        Node originCur = origin, copyCur = copy;
        while (originCur != null) {
            Node random = originCur.random;
            if (random != null) {
                Node temp = copy;
                while (temp != null) {
                    if (temp.val == random.val) {
                        copyCur.random = temp;
                        break;
                    }
                    temp = temp.next;
                }

            }
            originCur = originCur.next;
        }
    }

    @Test
    public void testCase1() {
        Node head = new Node(1, null, null);
        Node next = new Node(2, null, null);
        head.next = next;
        head.random = next;
        next.random = next;

        copyRandomList(head);
    }


    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
