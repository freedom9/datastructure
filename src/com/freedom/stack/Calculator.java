package com.freedom.stack;

/**
 * @author freedom
 * @date 2020/8/23 22:13
 */
public class Calculator {

    public static void main(String[] args) {

        String expression = "7 * 2 * 2 - 50 + 4 / 2 + 45";

        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        // 将每次扫描得到char保留到ch
        char ch = ' ';
        String keepNum = "";

        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);

            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                    // 如果符合栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的操作符，
                    // 就需要从数据栈中pop出两个数，再从符合栈中pop出一个符号，进行运算，
                    // 将得到结果入数据栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    // 如果符号栈为空，直接入栈
                    operStack.push(ch);
                }
            } else {
                // 处理数时，需要查看下一位是否也是数字
                keepNum += ch;

                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum.trim()));
                } else {
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum.trim()));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }

        res = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, res);
    }
}
