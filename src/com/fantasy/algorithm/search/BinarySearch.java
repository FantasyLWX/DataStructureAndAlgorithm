package com.fantasy.algorithm.search;

/**
 * 二分查找
 *
 * <pre>
 *     author  : Fantasy
 *     version : 1.0, 2020-08-22
 *     since   : 1.0, 2020-08-22
 * </pre>
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 3, 4, 5, 5, 7, 7, 9, 10, 10 };
        System.out.println("查找元素 " + arr[3] + " 的索引为: " + binarySearch(arr, arr[3]));
        System.out.println("查找元素 " + arr[3] + " 的索引为: " + binarySearchRecursion(arr, arr[3]));
        System.out.println("查找第一个等于 " + arr[2] + " 的元素的索引为: " + binarySearchFirst(arr, arr[2]));
        System.out.println("查找最后一个等于 " + arr[2] + " 的元素的索引为: " + binarySearchLast(arr, arr[2]));
        System.out.println("查找第一个大于等于 " + arr[3] + " 的元素的索引为: " + binarySearchFirstGreaterEqual(arr, arr[3]));
        System.out.println("查找第一个大于 " + arr[3] + " 的元素的索引为: " + binarySearchFirstGreater(arr, arr[3]));
        System.out.println("查找最后一个小于等于 " + arr[8] + " 的元素的索引为: " + binarySearchLastLessEqual(arr, arr[8]));
        System.out.println("查找最后一个小于 " + arr[8] + " 的元素的索引为: " + binarySearchLastLess(arr, arr[8]));
    }

    /**
     * 二分查找算法
     *
     * @param arr    有序数组
     * @param target 目标值
     * @return 索引
     */
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找算法（递归）
     *
     * @param arr    有序数组
     * @param target 目标值
     * @return 索引
     */
    public static int binarySearchRecursion(int[] arr, int target) {
        return binarySearchRecursionHelper(arr, 0, arr.length - 1, target);
    }

    private static int binarySearchRecursionHelper(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursionHelper(arr, mid + 1, high, target);
        } else {
            return binarySearchRecursionHelper(arr, low, mid - 1, target);
        }
    }

    /**
     * 查找第一个等于给定值的元素
     *
     * @param arr    有序数组
     * @param target 目标值
     * @return 索引
     */
    public static int binarySearchFirst(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (arr[mid - 1] != target)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个等于给定值的元素
     *
     * @param arr    有序数组
     * @param target 目标值
     * @return 索引
     */
    public static int binarySearchLast(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                if ((mid == arr.length - 1) || (arr[mid + 1] != target)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param arr    有序数组
     * @param target 目标值
     * @return 索引
     */
    public static int binarySearchFirstGreaterEqual(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= target) {
                if ((mid == 0) || (arr[mid - 1] < target)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (arr[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于给定值的元素
     *
     * @param arr    有序数组
     * @param target 目标值
     * @return 索引
     */
    public static int binarySearchFirstGreater(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > target) {
                if ((mid == 0) || (arr[mid - 1] <= target)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (arr[mid] <= target) {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @param arr    有序数组
     * @param target 目标值
     * @return 索引
     */
    public static int binarySearchLastLessEqual(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] <= target) {
                if ((mid == arr.length - 1) || (arr[mid + 1] > target)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于给定值的元素
     *
     * @param arr    有序数组
     * @param target 目标值
     * @return 索引
     */
    public static int binarySearchLastLess(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                if ((mid == arr.length - 1) || (arr[mid + 1] >= target)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

}