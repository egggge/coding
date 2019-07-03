package Sort;

/**
 * @author chendan
 * @date 2019/7/3 10:14
 */
public class QuickSort {
    public int quickPartition(int[] data,int i,int j){
        //用data[0]表示临时变量
        data[0]=data[i];
        while (i<j){
            while (i<j&&data[j]>=data[0]){
                j--;
            }
            //if语句是换位置
            if (i<j){
                data[i]=data[j];
                i++;
            }
            while (i<j&&data[i]<=data[0]){
                i++;
            }
            if (i<j){
                data[j]=data[i];
                j--;
            }
        }
        //这句话是什么意思
        //因为每次赋值只改变了一个，没有两个都改变
        data[i]=data[0];
        return i;

    }
    public void quickSort(int[] data,int s,int t){
        int i=0;
        while (s<t){
            i=quickPartition(data,s,t);
            quickSort(data,s,i-1);
            quickSort(data,i+1,t);
        }

    }
}
