package sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 3, 1, 5};
        int[] b = {2, 4, 6, 3, 1, 5};
        int[] c = {2, 4, 6, 3, 1, 5};
        int[] d = {2, 4, 6, 3, 1, 5};
        int[] e = {2, 4, 6, 3, 1, 5};
        BubbleSort bubbleSort = new BubbleSort();
        InsertSort insertSort = new InsertSort();
        SelectSort selectSort = new SelectSort();
        MergeSort mergeSort = new MergeSort();
        QuikSort quikSort = new QuikSort();

        bubbleSort.sort(a);
        insertSort.sort(b);
        selectSort.sort(c);

        // for-each语法，底层是iteratorb
        for (int value : a) {
            System.out.print(value + ",");
        }
        System.out.println();
        for (int value : b) {
            System.out.print(value + ",");
        }

        System.out.println();
        for (int value : c) {
            System.out.print(value + ",");
        }

        System.out.println();

        mergeSort.sort(d);

        for (int value : d) {
            System.out.print(value + ",");
        }

        System.out.println();

        mergeSort.sort(e);

        for (int value : e) {
            System.out.print(value + ",");
        }
    }
}
