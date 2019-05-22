/**
 * @Author: egg
 * @Date: 2019-05-05 15:16
 */
public class RecursionLoops {
    public static int stepsCount(int n){
        int count=0;
        if (n==1){return count=1;}
        else if (n==2){return count=2;}
        else if (n==0){return count;}
        else {
            return stepsCount(n-1)+stepsCount(n-2);
        }

    }

    /**
     * 非递归形式怎么实现
     * @param n
     * @return
     */

    public static void main(String[] args){
        System.out.println(stepsCount(100));

    }
}
