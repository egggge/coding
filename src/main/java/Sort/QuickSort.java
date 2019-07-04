package Sort;

/**
 * @author chendan
 * @date 2019/7/3 10:14
 */
public class QuickSort {
    public static void quickPartition(int[] data,int startindex,int endindex) {
        if (data != null && data.length >0) {
            int start = startindex, end = endindex;
            int target = data[startindex];
            while (start < end) {
                while (start < end) {
                    if (data[end] < target) {
                        int temp = data[end];
                        data[end] = data[start];
                        data[start] = temp;
                        start++;
                        break;
                    } else {
                        end--;
                    }
                }
                while (start < end) {
                    if (data[start] > target) {
                        int temp = data[end];
                        data[end] = data[start];
                        data[start] = temp;
                        end--;
                        break;
                    } else {
                        start++;
                    }
                }
            }
            if ((start - 1) > startindex) {
                quickPartition(data, startindex, start - 1);
            }
            if ((end + 1) < endindex) {
                quickPartition(data, end + 1, endindex);
            }
        }
    }

    public static void main(String[] args) {
        int[] data={3,6,7,0,8,9,1,5};
        quickPartition(data,0,data.length-1);
        for (int i:data){
            System.out.println(i);
        }

    }
}
