package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串
 */
public class No20ValidParentheses {
    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public boolean isValid(String s) {
        Map<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put('[', ']');
        parenthesesMap.put('(', ')');
        parenthesesMap.put('{', '}');


        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (parenthesesMap.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }

                Character pop = stack.pop();
                if (c != parenthesesMap.get(pop)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    @Test
    public void testCase1() {
        boolean valid = isValid("()");
        assertTrue(valid);
    }

    @Test
    public void testCase2() {
        boolean valid = isValid("()[]{}");
        assertTrue(valid);
    }

    @Test
    public void testCase3() {
        boolean valid = isValid("(]");
        assertFalse(valid);
    }

    @Test
    public void testCase4() {
        boolean valid = isValid("");
        assertTrue(valid);
    }

    @Test
    public void testCase5() {
        boolean valid = isValid("}");
        assertFalse(valid);
    }

    @Test
    public void testCase6() {
        boolean valid = isValid("{");
        assertFalse(valid);
    }
}
