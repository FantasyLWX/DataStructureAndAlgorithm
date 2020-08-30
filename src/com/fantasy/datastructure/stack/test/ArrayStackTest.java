package com.fantasy.datastructure.stack.test;

import com.fantasy.datastructure.stack.ArrayStack;

/**
 * “顺序栈”的测试类
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-30
 *     since   : 1.0, 2020-08-30
 * </pre>
 */
public class ArrayStackTest {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println("size : " + stack.size());
    }

}
