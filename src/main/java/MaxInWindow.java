import java.util.*;

/**
 * @author chendan
 * @date 2019/6/18 20:45
 */
public class MaxInWindow {
    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums,int k){
        if(nums == null || nums.length == 0) return new int[0];
        //重写方法实现大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k,new Comparator<Integer>(){
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
            }
        });
        int[] res = new int[nums.length + 1 - k];
        for(int i = 0; i < nums.length; i++){
            // 把窗口最左边的数去掉
            if(i >= k) pq.remove(nums[i - k]);
            // 把新的数加入窗口的堆中
            pq.offer(nums[i]);
            // 堆顶就是窗口的最大值
            if(i + 1 >= k) res[i + 1 - k] = pq.peek();
        }
        return res;
    }

    /**
     * 加入一个新数据：没到3个将最小的删除
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length == 0)
        {
            return new int[0];
        }
        LinkedList<Integer> deque = new LinkedList<Integer>();
        //先设置结果数组的长度
        int[] res = new int[nums.length + 1 - k];
        for(int i = 0; i < nums.length; i++){
            // 每当新数进来时，如果发现队列头部的数的下标与i的差值==k，扔掉
            if(!deque.isEmpty() && deque.getFirst() == i - k)
            {
                System.out.println("first:"+deque.getFirst());
                deque.poll();
            }
            //把队列尾部所有比新数小的都扔掉，保证队列是降序的
            //保证队列不为空是保证一直都有3个数
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i])
            {
                System.out.println("last:"+deque.getLast());
                deque.removeLast();
            }
            //加入新数
            deque.addLast(i);
            // i>=2,也就是已经加入3个数。队列头部就是该窗口内第一大的
            if((i + 1) >= k)
            {
                res[i + 1 - k] = nums[deque.peek()];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] data={2,3,6,2,6,2,5,1};
        int[] res=maxSlidingWindow2(data,3);
        for (int i:res){
            System.out.printf(i+" ");
        }

    }

}
