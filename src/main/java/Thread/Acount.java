package Thread;

/**
 * @Author: egg
 * @Date: 2019-08-30 09:18
 * 银行存取款就是对共享数据的不同操作
 * 共享数据和操作全部在Acount对象中，实例化后将对象传递给两个Runnable对象，这两个对象分别选取自己需要进行操作
 */
public class Acount {
    private int money;
    public Acount(int money){
        this.money=money;
    }

    public synchronized void getMoney(int money){
        //注意这个地方必须用while循环，因为即便再存入钱也有可能比取的要少
        while(this.money<money){
            System.out.println("取款："+money+" 余额："+this.money+" 余额不足，正在等待存款......");
            try{ wait();} catch(Exception e){}
        }
        this.money=this.money-money;
        System.out.println("取出："+money+" 还剩余："+this.money);

    }

    public synchronized void setMoney(int money){

        try{ Thread.sleep(10);}catch(Exception e){}
        this.money=this.money+money;
        System.out.println("新存入："+money+" 共计："+this.money);
        notify();
    }

    public static void main(String args[]){
        Acount Acount=new Acount(0);
        Bank b=new Bank(Acount);
        Consumer c=new Consumer(Acount);
        new Thread(b).start();
        new Thread(c).start();
    }
}
//存款类
class Bank implements Runnable {
    Acount Acount;
    public Bank(Acount Acount){
        this.Acount=Acount;
    }
    @Override
    public void run(){
        while(true){
            int temp=(int)(Math.random()*1000);
            Acount.setMoney(temp);
        }
    }

}
//取款类
class Consumer implements Runnable {
    Acount Acount;
    public Consumer(Acount Acount){
        this.Acount=Acount;
    }
    @Override
    public void run(){
        while(true){
            int temp=(int)(Math.random()*1000);
            Acount.getMoney(temp);
        }
    }
}
