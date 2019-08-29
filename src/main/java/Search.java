/**
 * @author chendan
 * @date 2019/6/5 8:21
 */
public class Search {
    /**
     * 在两个排序数组中找出中位数
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        // to ensure m<=n
        if (m > n) {
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            //类似于二分查找
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            //小数组提供的是0-（i-1）
            //大数组提供的是0-（j-1）
            if (i < iMax && B[j-1] > A[i]){
                // i is too small
                iMin = i + 1;
            }
            ////m数组提供少一点
            else if (i > iMin && A[i-1] > B[j]) {
                // i is too big
                iMax = i - 1;
            }
            else {
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
    /**
     * 找关键字为key的数据元素
     * @param data
     * @param key
     * @return
     */
    public int binarySearch(int[] data,int key){
        if (data.length==0){
            return -1;
        }
        //lo从1开始
        int lo=1;
        int hi=data.length;
        int mid=0;
        while (lo<=hi){
            mid=(lo+hi)>>1;
            //注意lo&hi!=mid;
            if (key>data[mid]){
                lo=mid+1;
            }
            else if (key<data[mid]){
                hi=mid-1;
            }
            else {
                return mid;
            }

        }
        //这里表示找寻失败
        return -1;
    }

    public int getFirstKey(int[] data,int length,int key,int start,int end){
        if (start>end){
            return -1;
        }
        int middleIndex=(start+end)>>1;
        int middleData=data[middleIndex];
        if (middleData==key){
            if ((middleIndex>0&&data[middleIndex-1]!=key)||middleIndex==0){
                return middleIndex;
            }
            else {
                end=middleIndex-1;
            }
        }else if(middleData>key) {
            end=middleIndex-1;

        }
        else {
            start=middleIndex+1;
        }
        return getFirstKey(data,length,key,start,end);
    }
    public int getLastKey(int[] data,int length,int key,int start,int end){
        if (start>end){
            return -1;
        }
        int middleIndex=(start+end)>>1;
        int middleData=data[middleIndex];
        if (middleData==key){
            if ((middleIndex<length-1&&data[middleIndex+1]!=key)||middleIndex==length-1){
                return middleIndex;
            }
            else {
                start=middleIndex+1;
            }
        }else if(middleData<key) {
            start=middleIndex+1;
        }
        else {
            end=middleIndex-1;
        }
        return getLastKey(data,length,key,start,end);
    }

    /**
     * 在排序数组中找重复数字
     * 二分查找：找到第一个key和最后一个key
     * @param data
     * @param length
     * @param key
     * @return
     */
    public int getNumberOfK(int[] data,int length,int key){
        int number=0;
        if (data!=null&&length>0){
            int first=getFirstKey(data,length,key,0,length-1);
            int last=getLastKey(data,length,key,0,length-1);

            if (first>-1&&last>-1){
                number=last-first+1;
            }

        }
        return number;
    }
}
