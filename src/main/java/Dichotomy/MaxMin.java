package Dichotomy;

/**
 * @Author: egg
 * @Date: 2019-09-05 10:36
 */
public class MaxMin {
    public static int maxMin(int arr[],int n,int k){
        int lo = 1, hi = 0;
        for (int i = 0; i < k; i++) {
            lo = Math.max(lo, arr[i]);
            hi += arr[i];
        }
        int m;
        while (lo <hi) {
            m = (lo + hi) >> 1;
            int u = 1,sum=0;
            for (int j=0;j<k;j++){
                if (sum+arr[j]>m){
                    u++;
                    sum=arr[j];

                }else {
                    sum+=arr[j];
                }

            }
            if (u<=n){
                hi=m;
            }else {
                lo=m+1;
            }
        }
        return hi;

    }
}
