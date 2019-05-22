/**
 * @Author: egg
 * @Date: 2019-05-13 15:00
 * 虽然右移两位等于除以2，但是效率低
 */
public class ContainNumOne {
    public static int countOne(int n){
        int count=0;
        while (n!=0){
            if ((n&1)!=0){
                count++;


            }
            n=n>>1;
            System.out.println(n);

        }
        return count;

    }

    /**
     * 在原数-1，与原数做与运算==最右边的1变为0
     * @param n
     * @return
     */
    public static int countOne2(int n){
        int count=0;
        while (n!=0){
           count++;
           n = (n-1)&n;

        }
        return count;

    }

    public static void main(String[] args){
        //System.out.println("count"+countOne(-8));
        System.out.println("count"+countOne2(-8));
    }
}
