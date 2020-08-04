package pattern;

public class KLargestTest {
    public static void main(String[] args) throws Exception {
        int[] a = {4, 5, 2, 2, 0};
        System.out.println(kLargest(a,4));
    }

    /**
     * 时间复杂度 O(n)= n + n/2+n/4+....
     * @param a
     * @param k
     * @return
     * @throws Exception
     */

    public static int kLargest(int a[], int k) throws Exception {
        int n = a.length;
        if (k > n || k <= 0) {
            throw new Exception("0<k<=n");
        }

        int start = 0;
        int end = n - 1;


        while (true) {
            /**
             * 使用快速排序思想,前面部分大于等于后面部分
             */
            int i = start;
            int j = end;

            /**
             * 为了使前后两部分均匀，临界点的选择有几种方法：
             * 1. 可以从第一个位置、中间位置、最后一个位置选择一个中间值
             * 2. 选择第一个元素
             */
            int value = a[i]; //第一个坑
            while (i < j) {
                /**
                 * 从后面找一个坑
                 */
                while (j > i) {
                    if (a[j] >= value) {
                        a[i] = a[j];
                        break;
                    } else {
                        j--;
                    }
                }
                /**
                 * 从前面找一个坑
                 */
                while (i < j) {
                    if (a[i] < value) {
                        a[j] = a[i];
                        break;
                    } else {
                        i++;
                    }
                }

            }
            a[i] = value;
            if (i == k - 1) {
                break;
            } else if (i < k - 1) {
                //下半部分查找
                start = i + 1;
            } else {
                end = i - 1;
            }

        }


        return a[k - 1];
    }
}
