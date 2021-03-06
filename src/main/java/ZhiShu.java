import java.util.Scanner;

/**
 * @author chendan
 * @date 2019/8/2 20:03
 */
public class ZhiShu {
    /**
     * 求整数N的质数，并按照从小到大输出
     * 比如：33={3，11}
     * @param n
     */
    public static void getZhiShu(int input){
        if(input==1){
            System.out.println(1);
        }
        int i;
        for(i=2;i<input;i++){
            while(input%i==0){
                input/=i;
                System.out.printf(i+" ");
            }
        }
        System.out.printf(input+" ");

    }

    /**
     * 判断一个数是不是质数（素数）
     * @param n
     * @return
     */
    public static boolean isPrim(int n){
        int count = n/2;
        while (count > 1) {
            if (n % count == 0 ) {
                return false;
            }
            count--;
        }

        return true;
    }



    /**
     * 四舍五入
     * 注意char->int转换
     */
    public void getApproximate(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            double m=sc.nextDouble();
            //.是一个正则表达式表示它匹配任何一个字符如："a" 或 "1"。
            char s=String.valueOf(m).split("\\.")[1].toCharArray()[0];
            int res=Integer.valueOf(String.valueOf(m).split("\\.")[0]);
            int num=(int)s-(int)'0';
            if (num>=5){
                System.out.println(res+1);
            }else {
                System.out.println(res);
            }


        }
    }

    /**
     * 求最大公约数
     * @param i
     * @param j
     * @return
     */

    public static int maxItem(int i, int j) {
        return j==0?i:maxItem(j,i%j);
    }

    public static void main(String[] args) {
        getZhiShu(8);
    }
}
