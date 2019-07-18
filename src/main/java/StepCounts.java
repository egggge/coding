/**
 * @author chendan
 * @date 2019/7/17 21:17
 */
public class StepCounts {
    /**
     * 青蛙跳台阶，每次可以1/2/3阶，共有多少种方法（递归方式）
     * @param n
     * @return
     */
    public int stepCounts(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        if (n==3){
            return 4;
        }

        return stepCounts(n-1)+stepCounts(n-2)+stepCounts(n-3);

    }

    /**
     * 青蛙跳台阶（循环）
     * @param n
     * @return
     */
    public int stepCountsNoRe(int n){
        int[] result={0,1,2,4};
        if (n<=3){
            return result[n];
        }
        int one=1;
        int two=2;
        int three=4;
        int res=0;
        for (int i=4;i<=n;i++){
            res=one+two+three;
            one=two;
            two=three;
            three=res;

        }
        return res;

    }

    public static void main(String[] args) {
        StepCounts stepCounts=new StepCounts();
        System.out.println(stepCounts.stepCountsNoRe(5));
    }
}
