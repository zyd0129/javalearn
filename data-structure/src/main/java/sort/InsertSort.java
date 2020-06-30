package sort;

/*
 int[] a = {2, 4, 6, 3, 1, 5};
 */
public class InsertSort implements ISort {
    public void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i <= n - 1; i++) {

            //就表示前面有序部分的边界，第一次有序部分只是a[0]边界为0，即i-1
            int j = i - 1;
            //从边界之后开始排 即i,移动之后当前要排序的元素位置被替换了，所以需要一个临时变量保存
            int value = a[i];
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];//往后移
                } else {
                    //已找到位置，跳出
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 分组插入排序，用于希尔排序，未完成
     * @param a
     * @param start
     * @param gap
     */
    public void sort(int[] a, int start, int gap) {
        int n = a.length;
        for (int i = 1; i <= n - 1; i++) {

            //就表示前面有序部分的边界，第一次有序部分只是a[0]边界为0，即i-1
            int j = i - 1;
            //从边界之后开始排 即i,移动之后当前要排序的元素位置被替换了，所以需要一个临时变量保存
            int value = a[i];
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];//往后移
                } else {
                    //已找到位置，跳出
                    break;
                }
            }
            a[j + 1] = value;
        }
    }
}
