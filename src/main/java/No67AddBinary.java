import org.junit.Assert;
import org.junit.Test;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 */
public class No67AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int now = sb.length() - 1;
        for (int i = b.toCharArray().length - 1; i >= 0; i--) {
            if (now < 0) {
                sb.insert(0, b.charAt(i));
                continue;
            }

            if (b.charAt(i) == '1') {
                sb.setCharAt(now, (char) (sb.charAt(now) + 1));
            }
            now--;
        }

        for (int i = sb.length() - 1; i > 0; i--) {
            char curChar = sb.charAt(i);
            char nextChar = sb.charAt(i - 1);
            if (curChar > '1') {
                int dived = Integer.parseInt(String.valueOf(curChar)) % 2 + 48;
                int step = Integer.parseInt(String.valueOf(curChar)) / 2;
                sb.setCharAt(i, (char) dived);
                sb.setCharAt(i - 1, (char) (nextChar + step));
            }
        }

        while (sb.charAt(0) >'1'){
            int dived = Integer.parseInt(String.valueOf(sb.charAt(0))) % 2 + 48;
            int step = Integer.parseInt(String.valueOf(sb.charAt(0))) / 2;
            sb.setCharAt(0, (char) dived);
            sb.insert(0,(char)('0'+step));
        }

        return sb.toString();
    }

    /**
     * 示例 1:
     * <p>
     * 输入: a = "11", b = "1"
     * 输出: "100"
     */
    @Test
    public void testCase1() {
        String result = addBinary("11", "1");
        Assert.assertEquals("100", result);
    }

    /**
     * 示例 2:
     * <p>
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */
    @Test
    public void testCase2() {
        String result = addBinary("1010", "1011");
        Assert.assertEquals("10101", result);
    }

    /**
     * 示例 3:
     * <p>
     * 输入: a = "1111", b = "1111"
     * 输出: "11110"
     */
    @Test
    public void testCase3() {
        String result = addBinary("1111", "1111");
        Assert.assertEquals("11110", result);
    }
}
