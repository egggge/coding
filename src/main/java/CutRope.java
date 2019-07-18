/**
 * @Author: egg
 * @Date: 2019-05-13 14:23
 */
public class CutRope {
    /**
     * 减绳子，每段长度乘积最大
     * @param len
     * @return
     */
    public static int maxCuttingRope(int len){
        if (len<2){
            return 0;
        }
        if (len==2){
            return 1;
        }
        if (len==3){
            return 2;
        }
        Integer[] maxProduct = new Integer[len+1];
        maxProduct[0]=0;
        maxProduct[1]=0;
        maxProduct[2]=1;
        maxProduct[3]=2;
        int max = 0;

        for (int i=4;i<=len;i++){
            max=0;
            //这里j<=i/2;因为如果j<i后面数字是重复的
            for (int j=1;j<=i/2;j++){
                int product = maxProduct[j]*maxProduct[i-j];
                if (max<product){
                    max=product;
                    maxProduct[i]=max;
                }
            }



        }
        max = maxProduct[len];
        return max;
    }
    public static void main(String[] args){
        System.out.println(maxCuttingRope(6));

    }
}
