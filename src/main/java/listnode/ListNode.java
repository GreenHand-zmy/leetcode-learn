package listnode;

import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode of(String numbers) {
        ListNode dummyNode = new ListNode(0);
        ListNode root = dummyNode;

        for (String number : numbers.split(",")) {
            root.next = new ListNode(Integer.parseInt(number));
            root = root.next;
        }

        return dummyNode.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val).append(",");

        ListNode next = this.next;
        while (next != null) {
            sb.append(next.val).append(",");
            next = next.next;
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNode node = (ListNode) o;
        return val == node.val &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
