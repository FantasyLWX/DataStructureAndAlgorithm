package com.fantasy.datastructure.array.test;

import com.fantasy.datastructure.array.OrderedArray;

/**
 * “大小固定的有序数组”的测试类
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-07-01
 *     since   : 1.0, 2020-07-01
 * </pre>
 */
public class OrderedArrayTest {

    public static void main(String[] args) {
        OrderedArray array = new OrderedArray(5);

        array.add(3); // 3
        array.add(1); // 1, 3
        array.add(5); // 1, 3, 5
        array.add(2); // 1, 2, 3, 5
        array.add(4); // 1, 2, 3, 4, 5
        System.out.println(array);

        array.remove(2); // 1, 2, 4, 5
        System.out.println(array);

        array.add(1); // 1, 1, 2, 4, 5
        System.out.println(array);
        System.out.println("array[2] = " + array.get(2)); // 2
    }

}