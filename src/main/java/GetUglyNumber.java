/**
 * @author chendan
 * @date 2019/5/30 9:28
 */
public class GetUglyNumber {
    public int getUglyNumber(int index){
        if (index<=0){
            return 0;
        }
        int[] pUglyNumbers=new int[index];
        pUglyNumbers[0]=1;
        int m2=0,m3=0,m5=0;
        int nextUglyIndex=1;

        while (nextUglyIndex<index){
            //找最小的原因是希望是排好序的
            int min = min(pUglyNumbers[m2]*2,pUglyNumbers[m3]*3,pUglyNumbers[m5]*5);
            pUglyNumbers[nextUglyIndex]=min;
            //3个while找T2,T3,T5
            while (pUglyNumbers[m2]*2<=pUglyNumbers[nextUglyIndex]){
                ++m2;
            }
            while (pUglyNumbers[m3]*3<=pUglyNumbers[nextUglyIndex]){
                ++m3;
            }
            while (pUglyNumbers[m5]*5<=pUglyNumbers[nextUglyIndex]){
                ++m5;
            }

            ++nextUglyIndex;

        }
        int ugly=pUglyNumbers[nextUglyIndex-1];
        return ugly;

    }
    public int min(int i,int j,int k){
        int temp=i<j?i:j;
        return temp<k?temp:k;
    }
}
