package sort;

public class MergeSort implements ISort {
    @Override
    public void sort(int[] a) {
        // 归并排序的思想，是二分 分治， 先分别排好前面部分，和后面部分，在合并排好的两部分。自下而上的排序。
        merge_sort(a, 0, a.length - 1);

    }

    public void merge_sort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = (end + start) / 2;
        merge_sort(a, start, partition);
        merge_sort(a, partition + 1, end);
        merge(a, start, partition, end);
    }

    public void merge(int[] a, int start, int partition, int end) {
        int[] newA = new int[end - start + 1];
        int i = start;
        int j = partition + 1;
        int z = 0;
        while (z < end - start + 1 & i < partition + 1 & j < end + 1) {
            if (a[i] <= a[j]) {
                newA[z] = a[i];
                i++;
            } else {
                newA[z] = a[j];
                j++;
            }
            z++;
        }
        // 将剩余的数据拷贝到临时数组tmp 只会有一个
        for (; i < partition + 1; i++) {
            newA[z] = a[i];
            z++;
        }
        // 将剩余的数据拷贝到临时数组tmp
        for (; j < end + 1; j++) {
            newA[z] = a[j];
            z++;
        }
        // 将tmp中的数组拷贝回
        for (z = 0; z < end - start + 1; z++) {
            a[start + z] = newA[z];
        }
    }
}
