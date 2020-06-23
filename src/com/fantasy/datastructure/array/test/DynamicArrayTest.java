package com.fantasy.datastructure.array.test;

import com.fantasy.datastructure.array.DynamicArray;

/**
 * “支持动态扩容的数组”的测试类
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-06-23
 *     since   : 1.0, 2020-06-23
 * </pre>
 */
public class DynamicArrayTest {

    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>(2);

        array.add(1); // 1
        array.addFirst(2); // 2, 1
        System.out.println(array);
        System.out.println("capacity = " + array.getCapacity());

        array.addLast(3); // 2, 1, 3
        array.addElement(1, 4); // 2, 4, 1, 3
        System.out.println(array);
        System.out.println("capacity = " + array.getCapacity());

        array.add(5); // 2, 4, 1, 3, 5
        array.add(6); // 2, 4, 1, 3, 5, 6
        System.out.println(array);
        System.out.println("capacity = " + array.getCapacity());
        System.out.println("size = " + array.getSize());

        array.remove(); // 2, 4, 1, 3, 5
        array.removeFirst(); // 4, 1, 3, 5
        array.removeLast(); // 4, 1, 3
        array.removeElement(1); // 4, 3
        System.out.println(array);
        System.out.println("capacity = " + array.getCapacity());
        System.out.println("size = " + array.getSize());

        array.set(1, 6); // 4, 6
        System.out.println(array);
        System.out.println("array[1] = " + array.get(1)); // 6
    }

}