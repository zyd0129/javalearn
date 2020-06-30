package sort;

public class SelectSort implements ISort {
    @Override
    public void sort(int[] a) {
        int n = a.length;
        //N个元素，排N-1趟
        for (int i = 1; i < n; i++) {
            // 每趟 只需从 [i-1,n-1] 选一个最小值,
            int head = i - 1;
            int min = head;
            for (int j = i - 1; j < n; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            //剩下的未排序队列中，最小值位置与未排列对头 交换位置
            int temp = a[min];
            a[min] = a[head];
            a[head] = temp;
        }
    }
}
