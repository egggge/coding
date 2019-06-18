/**
 * @author chendan
 * @date 2019/6/18 9:32
 */
public class NumberAppearOnce {
    /**
     * 数组中只出现一次的数字
     * @param data
     * @return
     */
    public static int[] findNumsAppearOnce(int[] data){
        int result = 0;
        for(int i=0;i<data.length;i++){
            result^=data[i];
        }
        System.out.println("异或结果："+result);
        int indexOf1 = findFirstBit1(result);
        System.out.println("第一个为1的位置："+indexOf1);
        int ret[] = new int[]{0,0};
        if(indexOf1<0)
            return ret;
        for(int i=0;i<data.length;i++){
            if((data[i]&indexOf1)==0)
                ret[0]^=data[i];
            else
                ret[1]^=data[i];
        }
        return ret;
    }

    /**
     * 将数组分为两个数组，
     * @param num
     * @return
     */
    public static int findFirstBit1(int num){
        if(num<0)
            return -1;
        int indexOf1 = 1;
        while (num!=0){
            if((num&1)==1)
                return indexOf1;
            else{
                num = num>>1;
                indexOf1*=2;
            }
        }
        return -1;
    }

    public static int findNumsAppearOnce2(int[] num){
        if (num.length<=0||num==null){
            throw new RuntimeException();
        }
        int[] bitSum = new int[32];
        for(int i=0;i<32;i++){
            bitSum[i]=0;
        }
        for(int i=0;i<num.length;i++) {
            int bitMask=1;
            for(int j=31;j>=0;j--) {
                //注意arr[i]&bitMask不一定等于1或者0，有可能等于00010000
                int bit=num[i]&bitMask;
                if(bit!=0){
                    bitSum[j]+=1;
                }
                //用左移来移动32位中的1
                bitMask=bitMask<<1;
            }
        }
        int result=0;
        for(int i=0;i<32;i++) {
            result=result<<1;
            result+=(bitSum[i]%3);
            //result=result<<1;  //不能放在后面，否则最前面一位就没了
        }
        return result;
    }

    public static void main(String[] args){
        int[] data = new int[]{2,2,3,6,3,2,3};
        //int[] result = findNumsAppearOnce(data); // 4,6
        int res=findNumsAppearOnce2(data);
        System.out.println(res);


    }
}
