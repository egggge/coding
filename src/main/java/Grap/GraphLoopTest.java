package Grap;
import java.util.*;

/**
 * @author chendan
 * @date 2019/8/21 10:58
 */

/**
 * 使用java实现图的图的广度优先 和深度优先遍历算法。
 */
public class GraphLoopTest {
    private Map<String, List<String>> graph = new HashMap<String, List<String>>();

    /**
     * 初始化图数据：使用邻居表来表示图数据。
     */
    public void initGraphData() {
//        图结构如下
//          1
//        /   \
//       2     3
//      / \   / \
//     4  5  6  7
//      \ | / \ /
//        8    9
        graph.put("1", Arrays.asList("2", "3"));
        graph.put("2", Arrays.asList("1", "4", "5"));
        graph.put("3", Arrays.asList("1", "6", "7"));
        graph.put("4", Arrays.asList("2", "8"));
        graph.put("5", Arrays.asList("2", "8"));
        graph.put("6", Arrays.asList("3", "8", "9"));
        graph.put("7", Arrays.asList("3", "9"));
        graph.put("8", Arrays.asList("4", "5", "6"));
        graph.put("9", Arrays.asList("6", "7"));
    }

    /**
     * 宽度优先搜索(BFS, Breadth First Search)
     * BFS使用队列(queue)来实施算法过程
     */
    private Queue<String> queue = new LinkedList<String>();
    private Map<String, Boolean> status = new HashMap<String, Boolean>();

    /**
     * 开始点
     *
     * @param startPoint
     */
    public void BFSSearch(String startPoint) {
        //1.把起始点放入queue；
        queue.add(startPoint);
        status.put(startPoint, false);
        bfsLoop();
    }

    private void bfsLoop() {
        //  1) 从queue中取出队列头的点；更新状态为已经遍历。
        //出队
        String currentQueueHeader = queue.poll();
        status.put(currentQueueHeader, true);
        System.out.println(currentQueueHeader);
        //  2) 找出与此点邻接的且尚未遍历的点，进行标记，然后全部放入queue中。
        List<String> neighborPoints = graph.get(currentQueueHeader);
        for (String poinit : neighborPoints) {
            //未被遍历
            if (!status.containsKey(poinit)) {
                if (queue.contains(poinit)) continue;
                queue.add(poinit);
                status.put(poinit, false);
            }
        }
        //如果队列不为空继续遍历
        if (!queue.isEmpty()) {
            bfsLoop();
        }
    }


    /**
     * 深度优先搜索(DFS, Depth First Search)
     * DFS使用队列(queue)来实施算法过程
     * stack具有后进先出LIFO(Last Input First Output)的特性，DFS的操作步骤如下：
     */
//     1、把起始点放入stack；
//     2、重复下述3步骤，直到stack为空为止：
//    从stack中访问栈顶的点；
//    找出与此点邻接的且尚未遍历的点，进行标记，然后全部放入stack中；
//    如果此点没有尚未遍历的邻接点，则将此点从stack中弹出。

    private Stack<String> stack = new Stack<String>();
    private Queue<String> queue2 = new LinkedList<String>();
    public void DFSSearch(String startPoint) {
        stack.push(startPoint);
        queue2.add(startPoint);
        status.put(startPoint, true);
        dfsLoop();
        for (String i:queue2){
            System.out.println(i);
        }
    }

    private void dfsLoop() {
        if(stack.empty()){
            return;
        }
        //查看栈顶元素，但并不出栈
        String stackTopPoint = stack.peek();
        //  2) 找出与此点邻接的且尚未遍历的点，进行标记，然后全部放入queue中。
        List<String> neighborPoints = graph.get(stackTopPoint);
        for (String point : neighborPoints) {
            //未被遍历
            if (!status.containsKey(point)) {
                stack.push(point);
                queue2.add(point);
                status.put(point, true);
                dfsLoop();
            }
        }
        String popPoint =  stack.pop();
    }

    public static void main(String[] args) {
        GraphLoopTest test = new GraphLoopTest();
        test.initGraphData();
//        test.BFSSearch("1");
        test.DFSSearch("1");
    }
}
