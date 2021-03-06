package Thread;

import java.util.LinkedList;

/**
 * 锁-》list
 * @Author: egg
 * @Date: 2019-06-27 15:27
 */
public class Storage {

    //最大存储量
    private final int MAX_SIZE=100;

    //仓库存储的载体

    private LinkedList<Object> list = new LinkedList<Object>();

    public int getMAX_SIZE()
    {
        return MAX_SIZE;
    }


    public void setList(LinkedList<Object> list)
    {
        this.list = list;
    }


    public LinkedList<Object> getList()
    {
        return list;
    }


    //生产产品

    public void produce(String producer)
    {
        synchronized (list)
        {
            // 如果仓库已满
            while (list.size() == MAX_SIZE)
            {
                System.out.println("仓库已满，【"+producer+"】： 暂时不能执行生产任务!");
                try
                {
                    // 由于条件不满足，生产阻塞
                    list.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            // 生产产品
            list.add(new Object());

            System.out.println("【"+producer+"】：生产了一个产品\t【现仓储量为】:" + list.size());

            list.notifyAll();
        }
    }

    // 消费产品

    public void consume(String consumer)
    {
        synchronized (list)
        {
            //如果仓库存储量不足
            while (list.size()==0)
            {
                System.out.println("仓库已空，【"+consumer+"】： 暂时不能执行消费任务!");
                try
                {
                    // 由于条件不满足，消费阻塞
                    list.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            list.remove();
            System.out.println("【"+consumer+"】：消费了一个产品\t【现仓储量为】:" + list.size());
            list.notifyAll();
        }
    }





}
