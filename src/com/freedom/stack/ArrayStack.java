package com.freedom.stack;

/**
 * @author freedom
 * @date 2020/8/23 21:16
 */
public class ArrayStack {

    // 栈顶
    private int top = -1;

    private int maxSize;

    private int[] stack;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 返回当前栈顶的值
     * @return
     */
    public int peek() {
        return stack[top];
    }

    public void push(int data) {
        if (isFull()) {
            throw new RuntimeException("栈满，不可插入");
        }

        stack[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无数据");
        }

        int value = stack[top];
        top--;
        return value;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("栈空，无数据");
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    /**
     * 返回运算符的优先级
     * @param oper
     * @return
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        }
        if (oper == '+' || oper == '-') {
            return 0;
        }
        return -1;
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val =='/';
    }

    public int cal(int num1, int num2, int oper) {
        int result = 0;

        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
        }
        return result;
    }
}
