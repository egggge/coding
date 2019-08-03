package Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: egg
 * @Date: 2019-07-11 16:40
 */
public class ThreadPool {

    public static void main(String[] args) {
        //提示说手动创建线程池更好？？
        ExecutorService pool= Executors.newCachedThreadPool();
        pool.submit(new TestThread());
        pool.submit(new TestThread());
        pool.shutdown();

    }
}

/**
 * 两个线程分别打印0-99
 */
class TestThread implements Runnable{
    public void run(){
        for (int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep( (long) (1000L * Math.random()));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
