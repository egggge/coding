package Thread;

/**
 * @Author: egg
 * @Date: 2019-08-29 18:53
 */
public class MutilThreadShareDateII {


    /**
     * 每个线程对共享数据操作不一样，用不同的runnable对象
     * @param args
     */
    public static void main(String[] args) {
        final MyData data = new MyData();
        for(int i=0;i<2;i++){
            new Thread(new Runnable(){
                @Override
                public void run() {
                    data.add();

                }

            }).start();
            new Thread(new Runnable(){
                @Override
                public void run() {
                    data.dec();

                }

            }).start();
        }
    }

}
//内部类

class MyData {
    private int j=0;
    public  synchronized void add(){
        j++;
        System.out.println("线程"+Thread.currentThread().getName()+"j为："+j);
    }
    public  synchronized void dec(){
        j--;
        System.out.println("线程"+Thread.currentThread().getName()+"j为："+j);
    }

}
