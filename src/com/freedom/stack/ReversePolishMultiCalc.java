package com.freedom.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author freedom
 * @date 2020/8/28 21:31
 * @descrption 逆波兰计算器完整版
 * 1、支持+ - * / （ ）；
 * 2、多位数，支持小数；
 * 3、兼容处理，过滤任何空白字符，包括空格、制表符、换页符。
 */
public class ReversePolishMultiCalc {

    /**
     * 匹配 + - * / ( ) 运算符
     */
    private static final String SYMBOL = "\\+|-|\\*|/|\\(|\\)";

    private static final String LEFT = "(";
    private static final String RIGHT = ")";
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";

    /**
     * 加减优先级
     */
    private static final int LEVEL_01 = 1;

    /**
     * 乘除优先级
     */
    private static final int LEVEL_02 = 2;

    /**
     * 括号优先级
     */
    private static final int LEVEL_HIGH = Integer.MAX_VALUE;

    private static Stack<String> stack = new Stack<>();

    private static List<String> data = Collections.synchronizedList(new ArrayList<>());

    /**
     * 判断是否数字 int/double/long/float
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断是不是运算符
     *
     * @param str
     * @return
     */
    public static boolean isSymbol(String str) {
        return str.matches(SYMBOL);
    }

    /**
     * 匹配运算符等级
     *
     * @param str
     * @return
     */
    public static int calcLevel(String str) {
        if ("+".equals(str) || "-".equals(str)) {
            return LEVEL_01;
        } else if ("*".equals(str) || "/".equals(str)) {
            return LEVEL_02;
        }
        return LEVEL_HIGH;
    }

    /**
     * 匹配
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static List<String> doMatch(String str) throws Exception {
        if (str == null || "".equals(str.trim())) {
            throw new RuntimeException("data is empty");
        }
        // \\s+ 匹配任何空白字符，包括空格、制表符，换页符等，等价于[\f\n\r\t\v]
        str = str.replaceAll("\\s+", "");

        if (!LEFT.equals(String.valueOf(str.charAt(0))) && !isNumber(String.valueOf(str.charAt(0)))) {
            throw new IllegalArgumentException("data illegal, start not number or '('");
        }

        int start = 0;

        for (int i = 0; i < str.length(); i++) {
            String each = String.valueOf(str.charAt(i));
            if (isSymbol(each)) {
                 if (stack.isEmpty() || LEFT.equals(each)
                        || (calcLevel(each) > calcLevel(stack.peek()) && calcLevel(each) < LEVEL_HIGH)) {
                    stack.push(each);
                } else if (RIGHT.equals(each)) {
                    while (!stack.isEmpty()) {
                        if (LEVEL_HIGH == calcLevel(stack.peek())) {
                            stack.pop();
                            break;
                        }
                        data.add(stack.pop());
                    }
                } else if (!stack.isEmpty() && calcLevel(each) <= calcLevel(stack.peek())) {
                    // 栈非空，操作符优先级小于等于栈顶优先级时出栈入列，直到栈为空，或者遇到了（，最后操作符入栈
                    while (!stack.isEmpty() && calcLevel(each) <= calcLevel(stack.peek())) {
                        if (calcLevel(stack.peek()) == LEVEL_HIGH) {
                            break;
                        }
                        data.add(stack.pop());
                    }
                    stack.push(each);
                }
                start = i;
            } else if (i == str.length() - 1 || isSymbol(String.valueOf(str.charAt(i + 1)))) {
                if (start == 0) {
                    while (LEFT.equals(String.valueOf(str.charAt(start)))) {
                        start++;
                    }
                } else {
                    start++;
                }

                each = str.substring(start, i + 1);
                if (isNumber(each)) {
                    data.add(each);
                    continue;
                }
                throw new IllegalArgumentException("data not match number");
            }
        }

        Collections.reverse(stack);
        data.addAll(new ArrayList<>(stack));

        return data;
    }

    /**
     * 计算结果
     *
     * @param list
     * @return
     */
    public static Double daCalc(List<String> list) {
        Double result = 0d;
        if (list == null || list.isEmpty()) {
            return null;
        }

        if (list.size() == 1) {
            return Double.valueOf(list.get(0));
        }

        List<String> assistList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            assistList.add(list.get(i));
            if (isSymbol(list.get(i))) {
                Double d = doTheMath(list.get(i - 2), list.get(i - 1), list.get(i));
                assistList.remove(i);
                assistList.remove(i - 1);
                assistList.set(i - 2, String.valueOf(d));
                assistList.addAll(list.subList(i + 1, list.size()));
                break;
            }
        }

        result = daCalc(assistList);
        return result;
    }

    /**
     * 运算
     *
     * @param s1
     * @param s2
     * @param symbol
     * @return
     */
    public static Double doTheMath(String s1, String s2, String symbol) {
        Double result;
        switch (symbol) {
            case ADD:
                result = Double.parseDouble(s1) + Double.parseDouble(s2);
                break;
            case SUB:
                result = Double.parseDouble(s1) - Double.parseDouble(s2);
                break;
            case MUL:
                result = Double.parseDouble(s1) * Double.parseDouble(s2);
                break;
            case DIV:
                result = Double.parseDouble(s1) / Double.parseDouble(s2);
                break;
            default:
                result = null;
        }
        return result;
    }

    public static void main(String[] args) {
//        String expression = " (( 12.8 + 0 \t+(2+3.55))*4))+10/5.0";
        String expression = "((12.8 + 3.55))";
        try {
            System.out.printf("%s = %s", expression, daCalc(doMatch(expression)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
