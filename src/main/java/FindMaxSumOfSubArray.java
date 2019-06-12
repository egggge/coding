/**
 * @author chendan
 * @date 2019/5/28 16:22
 */
public class FindMaxSumOfSubArray {
    /**
     * 1.如果全是负数
     * @param data
     * @return
     */
    public int findMaxSum(int[] data){
        if (data==null){
            System.out.println("数组为空");
            return 0;
        }
        int temp=0;
        int res=data[0];
        int secend=0;
        for (int i:data){
            //和小于本身
            if (temp+i<i){
                temp=i;
                if (temp>res){
                    res=temp;
                }
            }
            else {
                if (i<0){
                    //添加了一个负数，先保留上一次结果，再加
                    secend=temp;
                    temp+=i;
                }
                if (i>=0){
                    temp+=i;
                    if (temp>secend){ res=temp; }
                    else { res=secend; }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] data={1,-2,3,10,-4,7,2,-5};
        FindMaxSumOfSubArray findMaxSumOfSubArray = new FindMaxSumOfSubArray();
        System.out.println(findMaxSumOfSubArray.findMaxSum(data));
    }

}
