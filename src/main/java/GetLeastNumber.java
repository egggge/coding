import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: egg
 * @Date: 2019-08-01 21:06
 */
public class GetLeastNumber {
    /**
     * 基于priorityQueue找到最小的k个数
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbersolution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                //降序
                //头节点为最大值
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}
