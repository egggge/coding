/**
 * @author chendan
 * @date 2019/5/27 11:05
 */
public class MoreHalf {
    private   boolean inputTnvalid =false;
    /**
     * 快排思想+超过一半的数值排序后一定在中间
     * 1.数组无效
     * 2.频率不到数组一半
     * @param data
     * @param len
     * @return
     */
    public int moreHalfNum(int[] data,int len){
        if (checkInvalidArray(data,len)){
            System.out.println("数组长度为0");
            return 0;
        }
        int mid= len>>1;
        int start = 0;
        int end=len-1;
        int index=partition(data,len,start,end);
        while (index!=mid){
            if (index>mid){
                index--;
            }
            if (index<mid){
                index++;
            }
        }
        int res=data[index];
        if (checkMoreThanHalf(data,len,res)){
            return res;
        }
        else {
            System.out.println("数字频率不足一半");
            return 0;
        }
    }
    public int partition(int[] data,int len,int lo,int hi){
        data[0]=data[lo];
        while (lo<hi){
            while (lo<hi&&data[hi]>data[0]){
                hi--;
            }
            if (lo<hi){
                data[lo]=data[hi];
                lo++;
            }
            while (lo<hi&&data[lo]<data[0]){
                lo++;
            }
            if (lo<hi){
                data[hi]=data[lo];
                hi--;
            }
        }
        data[lo]=data[0];
        return lo;

    }
    public boolean checkInvalidArray(int[] data,int len){
        inputTnvalid=false;
        if (data==null||len<=0){
            inputTnvalid=true;
        }
        return inputTnvalid;
    }
    public boolean checkMoreThanHalf(int[] data,int len,int number){
        int times=0;
        for (int i=0;i<len;i++){
            if (data[i]==number){
                times++;
            }
        }
        boolean isMoreHalf = true;
        if (times*2<=len){
            inputTnvalid=true;
            isMoreHalf=false;
        }
        return isMoreHalf;
    }

    public static void main(String[] args) {
        MoreHalf moreHalf = new MoreHalf();
        int[] data = {2,8,3,2,1,6,5,4,2};
        System.out.println(moreHalf.moreHalfNum(data,data.length));
    }
}

