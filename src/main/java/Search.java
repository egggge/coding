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
        return 0;
    }
}
