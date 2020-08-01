package exercise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CQueueTest {
    public static void main(String[] args) throws Exception {

        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    public static class CQueue {
        private int[] inputStack = new int[1000];
        private int[] outputStack = new int[1000];
        private int inputIndex = 0;
        private int ouputIndex = -1;
        private final int MAX = 1000;

        public CQueue() {

        }

        /**
         * 进入入栈
         *
         * @param value
         */
        public void appendTail(int value) throws Exception {
            if (inputIndex == MAX) {
                throw new Exception("栈已满");
            }
            inputStack[inputIndex] = value;
            inputIndex++;
        }

        /**
         * 先从出栈获取元素，如果为空，则把所有入栈，压入出栈
         *
         * @return
         */
        public int deleteHead() {
            int value = -1;
            if (ouputIndex == -1 && inputIndex == 0) {
                return value;
            }
            if (ouputIndex != -1) {
                value =outputStack[ouputIndex];
            } else {
                while (inputIndex > 0) {
                    inputIndex--;
                    ouputIndex++;
                    outputStack[ouputIndex] = inputStack[inputIndex];
                }
                value = outputStack[ouputIndex];
            }
            ouputIndex--;
            return value;
        }
    }
    class CQueue1 {
        // java推荐使用deque来作为队列或者栈，双端队列，可以作为(FIFO)队列使用,或者栈使用(FILO)
        // Deque的实现，有ArrayQueue,LinkedList; arrayQueue自带扩容功能
        Deque<Integer> stack1;
        Deque<Integer> stack2;

        public CQueue1() {
            stack1 = new LinkedList<Integer>();
            stack2 = new LinkedList<Integer>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            // 如果第二个栈为空
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                return -1;
            } else {
                int deleteItem = stack2.pop();
                return deleteItem;
            }
        }
    }
}
