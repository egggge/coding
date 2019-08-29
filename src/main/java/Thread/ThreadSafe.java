package Thread;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: egg
 * @Date: 2019-08-26 19:49
 */

/**
 * 在主线程新建一个ArrayList,然后开1000个子线程向这个数组里面添加数组，每次添加100个。
 */
public class ThreadSafe {
    public static void testCounter()

    {
        List<Object> list = new Vector<Object>();
        // 计数器
        Counter counter = new Counter();

        // 线程数量(1000)
        int threadCount = 1000;

        // 用来让主线程等待threadCount个子线程执行完毕
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        // 启动threadCount个子线程
        for(int i = 0; i < threadCount; i++)
        {
            Thread thread = new Thread(new MyThread(counter, countDownLatch));
            thread.start();
        }

        try
        {
            // 主线程等待所有子线程执行完成，再向下执行
            countDownLatch.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // 计数器的值
        System.out.println(counter.getCount());
    }


    public static void test(){
        List<Object> list = new ArrayList<Object>();

        // 线程数量(1000)
        int threadCount = 1000;

        // 用来让主线程等待threadCount个子线程执行完毕
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        // 启动threadCount个子线程
        for(int i = 0; i < threadCount; i++)
        {
            Thread thread = new Thread(new MyThread(list, countDownLatch));
            thread.start();
        }
        try
        {
            // 主线程等待所有子线程执行完成，再向下执行
            countDownLatch.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // List的size
        System.out.println(list.size());


    }
    public static void main(String[] args) {

        // 进行10次测试
        for(int i = 0; i < 10; i++)
        {
            test();
        }

    }

}
class MyThread implements Runnable{
    private Counter counter;
    private List<Object> list;
    //CountDownLatch 的作用是：当一个线程需要另外一个或多个线程完成后，再开始执行。
    // 比如主线程要等待一个子线程完成环境相关配置的加载工作，主线程才继续执行，就可以利用 CountDownLatch 来实现。

    private CountDownLatch countDownLatch;
    public MyThread(List<Object> list,CountDownLatch countDownLatch){
        this.list=list;
        this.countDownLatch=countDownLatch;
    }
    public MyThread(Counter counter, CountDownLatch countDownLatch)
    {
        this.counter = counter;
        this.countDownLatch = countDownLatch;
    }
//    public void run()
//    {
//        // 每个线程向Counter中进行10000次累加
//        for(int i = 0; i < 10000; i++)
//        {
//            counter.addCount();
//        }
//
//        // 完成一个子线程
//        countDownLatch.countDown();
//    }

    public void run(){
        for (int i=0;i<100;i++){
            list.add(new Object());
        }
        countDownLatch.countDown();
    }

}
class Counter
{
    private int count = 0;

    public int getCount()
    {
        return count;
    }

    public synchronized void addCount()
    {
        count++;
    }
}
