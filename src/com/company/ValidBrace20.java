package com.company;

import java.util.Stack;

/**
 *
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnbcaj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class ValidBrace20 {


    public static void main(String[] args) {


        String str = "()";

        System.out.println("isValidBrace:" + isValidBrace(str));

    }

    public static boolean isValidBrace(String str) {

        char[] quotes = str.toCharArray();

        Stack statck = new Stack<Character>();

        for (int i = 0; i < quotes.length; i++) {
            char s = quotes[i];

            if (s == '(' || s == '[' || s == '{') {
                //入栈
                statck.push(s);
            } else {
                if (statck.isEmpty()) {
                    //如果全部是左边，都在栈里边，那么也是空的
                    return false;
                } else {
                    if (s == ')') {
                        char popStr = (char) statck.pop();
                        if (popStr !='(') {
                            return false;
                        }
                    } else if (s == ']') {
                        Character popStr = (Character) statck.pop();
                        if (popStr !='[') {
                            return false;
                        }
                    } else if (s == '}') {
                        Character popStr = (Character) statck.pop();
                        if (popStr !='{') {
                            return false;
                        }
                    }
                }
            }
        }
        return statck.isEmpty() ? true : false;
    }
}
