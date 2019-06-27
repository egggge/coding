package BaseJava;

/**
 * @Author: egg
 * @Date: 2019-06-25 20:57
 */
public class ThreadOne extends Thread {
    @Override
    public void run(){
        int i = 0;
        while (i<6){
            System.out.println(i);
            i++;
        }
    }
}
