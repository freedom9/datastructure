package com.freedom.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author freedom
 * @date 2020/8/28 20:40
 */
public class InfixToSuffixExpression {

    /**
     * 步骤：
     * 1、初始化两个栈：运算符栈s1和存储中间结果的栈s2；
     * 2、从左至右扫描中缀表达式；
     * 3、遇到操作数时，将其压s2;
     * 4、遇到运算符时，比较其与s1栈顶运算符的优先级；
     *     4.1 如果s1为空，或栈顶运算符为左括号“(”，也将运算符压入s1；
     *     4.2 否则，若优先级比栈顶运算符的高，也将运算符压入s1；
     *     4.3 否则，将s1栈顶的运算符弹出并压入到s2中，再次将运算符与s1中新的栈顶运算符相比较；
     * 5、遇到括号时：
     *     5.1 如果是左括号“(”，则直接压入s1；
     *     5.2 如果是左括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃；
     * 6、重复步骤2至5，直到表达式的最右边；
     * 7、将s1中剩余的运算符依次弹出并压入s2；
     * 8、依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式。
     *
     * @param infixExceptionList 中缀表达式
     * @return
     */
    public static List<String> infixToSuffixException(List<String> infixExceptionList) {
        // 符号栈
        Stack<String> symbolStack = new Stack<>();
        // 因为结果栈没有pop操作，而且我们最后需要逆序输出，这里为了方便，用list代替stack存储结果
        List<String> resultList = new ArrayList<>();

        for (String item : infixExceptionList) {
            if (item.matches("\\d+")) {
                resultList.add(item);
            } else if (item.equals("(")) {
                symbolStack.push(item);
            } else if (item.equals(")")) {
                while (!symbolStack.peek().equals("(")) {
                    resultList.add(symbolStack.pop());
                }
                symbolStack.pop();
            } else {
                while (symbolStack.size() != 0 && priority(symbolStack.peek().charAt(0)) >= priority(item.charAt(0))) {
                    resultList.add(symbolStack.pop());
                }
                symbolStack.push(item);
            }
        }

        while (symbolStack.size() != 0) {
            resultList.add(symbolStack.pop());
        }
        return resultList;
    }

    /**
     * 返回运算符的优先级
     * @param oper
     * @return
     */
    public static int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        }
        if (oper == '+' || oper == '-') {
            return 0;
        }
        return -1;
    }
}
