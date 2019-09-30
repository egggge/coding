package Dichotomy;

import java.util.Arrays;

/**
 * @Author: egg
 * @Date: 2019-09-05 10:36
 */
public class MinMax {
    public static boolean judge(int dis,int[] arr,int k,int n){
        int num=1,pre=arr[0];
        for (int i=1;i<k;i++){
            if (arr[i]-pre>=dis){
                num++;
                pre=arr[i];
                if (num==n){
                    return true;
                }
            }
        }
        return false;
    }


    public static int minMax(int[] arr,int n,int k){
        int lo=0,hi=0;
        Arrays.sort(arr);
        int len=arr.length-1;
        hi=arr[0]-arr[len];
        int m;
        int ans;
        while (lo<=hi){
            m=(lo+hi)>>1;
            if (judge(m,arr,k,n)){
                ans=m;
                lo=m+1;
            }else {
                hi=m-1;
            }
        }
        return lo-1;
    }
}
