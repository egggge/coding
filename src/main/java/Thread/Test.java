package Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: egg
 * @Date: 2019-06-27 15:31
 */
public class Test {
    public static void main(String[] args) {
        final int a = 2019;
        new Thread(){
            @Override
            public void run(){
                System.out.println(a);
            }
        }.start();
    }


//        Storage storage=new Storage();
//        //线程池的使用
//        /**
//         * @corePoolSize：核心池的大小:当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中；
//         * @maximumPoolSize：线程池最大线程数，它表示在线程池中最多能创建多少个线程；
//         * @keepAliveTime：表示线程没有任务执行时最多保持多久时间会终止。默认情况下，只有当线程池中的线程数大于corePoolSize时，keepAliveTime才会起作用，如果一个线程空闲的时间达到keepAliveTime，则会终止，直到线程池中的线程数不超过corePoolSize。
//         * 但是如果调用了allowCoreThreadTimeOut(boolean)方法，在线程池中的线程数不大于corePoolSize时，keepAliveTime参数也会起作用，直到线程池中的线程数为0；
//         * unit：参数keepAliveTime的时间单位
//         * @workQueue：一个阻塞队列，用来存储等待执行的任务
//         */
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<Runnable>(5));
//
//        for(int i=0;i<15;i++){
//            MyTask myTask = new MyTask(i);
//            executor.execute(myTask);
//            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
//                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
//        }
//        executor.shutdown();
//
//        for(int i=1;i<6;i++)
//        {
//            int finalI = i;
//            new Thread(new Runnable() {
//                public void run() {
//                    storage.produce(String.format("生成者%d:", finalI));
//                }
//            }).start();
//        }
//
//        for(int i=1;i<4;i++)
//        {
//            int finalI = i;
//            new Thread(()-> storage.consume(String.format("消费者%d:", finalI))).start();
//        }

}
