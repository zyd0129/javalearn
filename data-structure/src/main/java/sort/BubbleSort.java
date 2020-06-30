package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 从小到大排序，有序递增数组
 */
public class BubbleSort implements ISort{
    public void sort(int[] array) {
        int n = array.length;
        boolean switchFlag = false;
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j <= n - 1 - 1 - (i - 1); j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j+1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    switchFlag=true;
                }
            }
            if(!switchFlag) break;
        }
    }
}
