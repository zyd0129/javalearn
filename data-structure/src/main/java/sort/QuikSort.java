package sort;

public class QuikSort implements ISort {
    @Override
    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        int l = start; // 记录左边挖的坑的位置
        int r = end; //记录右边挖的坑的位置

        int pivot = a[l];

        while (r != l) {

            for (; r > l; r--) {
                if (a[r] < pivot) {
                    a[l] = a[r]; //填左边的坑
                    l++; //记录下一次左边查找开始位置
                    break;
                }
            }

            for (; l < r; l++) {
                if (a[l] >= pivot) {
                    a[r] = a[l]; //填右边的坑
                    r++;//记录下一次右边查找开始位置
                }
            }
        }

        a[r] = pivot;
        quickSort(a, start, pivot - 1);
        quickSort(a, pivot + 1, end);
    }
}
