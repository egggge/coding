package Thread;

/**
 * @Author: egg
 * @Date: 2019-08-29 18:43
 */
public class MutilThreadShareDate {
    /**
     * 线程共享数据方式1：买票系统（每个操作都是一样的）
     * 将共享数据和共同操作放进同一个runnable类对象中
     * @param args
     */
    public static void main(String[] args) {

        oneRunnable();

    }


//买票系统

    public static void oneRunnable(){

        ShareDate1 date1 = new ShareDate1();

// 因为四个线程访问的是同一个date对象，所以数据之间可以共享

        new Thread(date1).start();

        new Thread(date1).start();

        new Thread(date1).start();

        new Thread(date1).start();

    }

}

class ShareDate1 implements Runnable {
    //共享数据

    int j = 100;

    public synchronized void decrement() {

        System.out.println(Thread.currentThread().getName() + ",做j--的操作," + j);

        j--;

    }


   @Override
    public void run() {

        /*

         * 怎么做到线程安全，保证，让票数大于0呢？

         * 因为票数j属于共享数据，当j满足条件时进去while循环，while循环中加了锁，保证线程安全

         * 当多个线程进入了while循环，在等待锁的时，别的线程对j进行了j--的操作，
         *
         * 当j减到0时，等待的线程获得锁之后，还会继续做j--的操作，导致j为负数，所以要对j再次加一判断。

         */

        while (j > 0) {
            //当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，
            // 一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。

            synchronized (this) {

                if (j > 0) {

//让当前线程停下10ms，让出cpu的执行权，其他线程不能获得锁，但是可以运行不需要该锁的代码。10s中到了，就自动向下执行

                    try {

                        Thread.sleep(10);

                    } catch (InterruptedException e) {

// TODO Auto-generated catch block

                        e.printStackTrace();

                    }

                    decrement();

                }

            }

        }

    }
}
