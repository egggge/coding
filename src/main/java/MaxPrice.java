/**
 * @Author: egg
 * @Date: 2019-07-30 17:12
 */
public class MaxPrice {
    /**
     * 记录前i-1个数字当中最小的数字
     * @param arr
     * @return
     */
    public static int getMaxPrices(int[] arr){
        int min=arr[0];
        int maxPrice=arr[1]-arr[0];

        for (int i=1;i<arr.length;i++){
            if (min>arr[i]){
                min=arr[i];
            }
            int temp=arr[i]-min;
            if (maxPrice<temp){
                maxPrice=temp;
            }
        }
        return maxPrice;

    }

    public static void main(String[] args) {
        int[] arr={9,11,8,5,7,12,16,14};
        System.out.println(getMaxPrices(arr));

    }
}
