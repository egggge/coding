/**
 * @author chendan
 * @date 2019/5/28 16:22
 */
public class FindMaxSumOfSubArray {
    /**
     * 连续子数组的最大和
     * @param arr
     * @return
     */
    public static int maxSumOfSubArray(int[] arr){
        if (arr.length!=0){
            int max=arr[0];
            int temp=arr[0];
            for (int i=1;i<arr.length;i++){
                temp=arr[i]>temp+arr[i]?arr[i]:temp+arr[i];
                max=max>temp?max:temp;
            }
            return max;
        }
        return Integer.MIN_VALUE;

    }



    public static void main(String[] args) {
        int[] data={-1,-2,-3,10,-4,-7,-2,5};
        System.out.println(maxSumOfSubArray(data));
    }

}
