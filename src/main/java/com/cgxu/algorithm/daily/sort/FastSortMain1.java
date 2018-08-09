package com.cgxu.algorithm.daily.sort;

/**
 * 类描述:
 *
 * @author: chenggangxu@sohu-inc.com
 * @date: 2018/8/9 下午1:16
 */
public class FastSortMain1 {


    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 7, 4, 6, 10};
        sort(array, 0, 5);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }


    public static int partition(int[] array, int lo, int hi) {
        //三数取中
        int mid = lo + (hi - lo) / 2;
        if (array[mid] > array[hi]) {
            swap(array[mid], array[hi]);
        }
        if (array[lo] > array[hi]) {
            swap(array[lo], array[hi]);
        }
        if (array[mid] > array[lo]) {
            swap(array[mid], array[lo]);
        }
        int key = array[lo];

        while (lo < hi) {
            while (array[hi] >= key && hi > lo) {
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo) {
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }

/*    public static void quick(int[] array, int lo, int hi) {
        if (hi - lo + 1 < 10) {
            insertSort(array);
        } else {
            quickSort(array, lo, hi);
        }
    }*/
}
