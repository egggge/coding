package Sort;

import java.util.Arrays;

/**
 * @author chendan
 * @date 2019/7/3 10:13
 */
public class MergeSort {
    /**
     *
     * @param arr
     * @param temp  临时数组
     * @param start 左边下标开始
     * @param t  右边下标开始
     * @param end 右边下标结束
     */

    public static void merge(int[] arr,int[] temp,int start,int t,int end){
        //左边数组的开始和结束
        int leftstatr=start;
        int leftend=t-1;

        //元素个数
        int num = end-start+1;
        //临时数组的开始
        int tempbegin=start;
        while (leftstatr<=leftend&&t<=end){
            if (arr[leftstatr]<=arr[t]){
                temp[tempbegin++]=arr[leftstatr++];
            }
            else {
                temp[tempbegin++]=arr[t++];

            }

        }

        while (t<=end){
            temp[tempbegin++]=arr[t++];

        }
        while (leftstatr<=leftend){
            temp[tempbegin++]=arr[leftstatr++];
        }
        //复制回原素组

        for (int q = 0; q <num; q++){
            arr[end]=temp[end];
            end--;

        }


    }
    public static void merge_sort(int[] arr,int[] temp,int start,int end){
        if (start<end){
            //将数组分为两部分
            int m=(start+end)/2;
            merge_sort(arr,temp,start,m);
            merge_sort(arr,temp,m+1,end);
            merge(arr,temp,start,m+1,end);

        }


    }
    private  static void mergeSort(int[] arr) {
        merge_sort(arr, new int[arr.length], 0, arr.length - 1);
    }



    public static void main(String[] args){
        int[] data = {49,23,15,9,20};
        mergeSort(data);


//        MergeSort sort = new MergeSort();
//        sort.mergeSort(data);
        System.out.println("排序后：" + Arrays.toString(data));
    }
}
