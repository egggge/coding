/**
 * @author chendan
 * @date 2019/5/30 19:12
 */
public class InversePairs {
    public int inversePairs(int[] data){
        if (data==null){
            return 0;
        }
        int len=data.length;
        int[] copy = new int[len];
        for (int i=0;i<len;i++){
            copy[i]=data[i];
        }
        int count = inversePairsCore(data,copy,0,len-1);
        return count;

    }
    public int inversePairsCore(int[] data,int[] copy,int start,int end){
        if (start==end){
            copy[start]=data[start];
            return 0;
        }
        //首先将数组分为两部分
        int len=(end-start)>>1;

        int left=inversePairsCore(copy,data,start,start+len);
        int right = inversePairsCore(copy,data,start+len+1,end);

        //i和j分别指向两部分的末尾
        int i=start+len;
        int j=end;
        int indexCopy=end;
        int count=0;

        while (i>=start&&j>=start+len+1){
            if (data[i]>data[j]){
                copy[indexCopy--]=data[i--];
                count+=j-start-len;
            }
            else {
                copy[indexCopy--]=data[j--];
            }
        }
        for (;i>=start;--i){
            copy[indexCopy--]=data[i];
        }
        for (;j>=start+len+1;j--){
            copy[indexCopy--]=data[j];
        }
        return left+right+count;
    }

    public static void main(String[] args) {
        int[] data = {7,5,6,4};
        InversePairs inversePairs = new InversePairs();
        System.out.println(inversePairs.inversePairs(data));

    }
}
