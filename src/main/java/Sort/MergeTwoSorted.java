package Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: egg
 * @Date: 2019-07-30 11:46
 */
public class MergeTwoSorted {
    /**
     * 不能用新的数组，因为长度不一定
     * @param arr1
     * @param arr2
     */
    public static void mergeTwoSorted(int[] arr1,int[] arr2){
        int len1=arr1.length;
        int len2=arr2.length;
        List<Integer> arr=new ArrayList<Integer>();
        int i=0;
        int j=0;
        while (i<len1&&j<len2){
            if (arr1[i]<arr2[j]){
                arr.add(arr1[i]);
                i++;
            }else if (arr1[i]==arr2[j]){
                arr.add(arr1[i]);
                i++;
                j++;
            }else {
                arr.add(arr2[j]);
                j++;

            }
        }
        if (i>=len1&&j<len2){
            while (j<len2){
                arr.add(arr2[j]);
                j++;
            }
        }
        if (j>=len2&&i<len1){
            while (i<len1){
                arr.add(arr1[i]);
                i++;
            }

        }
        for (int m:arr){
            System.out.println(m);
        }
    }

    public static void main(String[] args) {
        int[] arr1={1,2,3,4};
        int[] arr2 ={2,4,5,6,7,8,9};
        mergeTwoSorted(arr1,arr2);
    }
}
