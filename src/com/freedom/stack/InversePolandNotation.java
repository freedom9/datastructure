package com.freedom.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author freedom
 * @date 2020/8/26 21:05
 */
public class InversePolandNotation {

    public static void main(String[] args) {

        // 1+((2+3)*4)-5 ——》1 2 3 + 4 * + 5 -
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpression(expression);

        List<String> suffixExpression = InfixToSuffixExpression.infixToSuffixException(infixExpressionList);
        System.out.printf("%s 中缀转后缀表达式 %s\n", expression, suffixExpression);

        System.out.printf("\"%s\"的计算结果是：%d", suffixExpression, calculate(suffixExpression));

        // (3 + 4) * 5 - 6 ——》3 4 + 5 * 6 -
//        String suffixExpression = "3 4 + 5 * 6 -";

//        List<String> list = getListString(suffixExpression);
//        System.out.println(list);

//        System.out.printf("\"%s\"的计算结果是：%d", suffixExpression, calculate(list));
    }

    /**
     * 将中缀表达式转为对应的List
     *
     * @param expression
     * @return
     */
    private static List<String> toInfixExpression(String expression) {
        List<String> list = new ArrayList<>();
        // 用于字符串拼接
        String str;
        char c;

        int i = 0;
        do {
            // 如果是一个非数字，直接加入list
            if ((c = expression.charAt(i)) < 48 || (c = expression.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else {
                str = "";
                while (i < expression.length() && (c = expression.charAt(i)) >= 48 && (c = expression.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }
        } while (i < expression.length());

        return list;
    }

    /**
     * 将逆波兰表达式放入list，方便操作
     *
     * @param suffixExpression
     * @return
     */
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String item : split) {
            list.add(item);
        }
        return list;
    }

    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();

        for (String item : list) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result = 0;
                switch (item) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                    default:
                        throw new RuntimeException("运算符有误");
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
