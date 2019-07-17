/**
 * @author chendan
 * @date 2019/6/5 8:21
 */
public class Search {
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
