package Sort;

/**
 * @author chendan
 * @date 2019/7/3 10:28
 */
public class BubbleSort {
    public static void swap(int a,int b){
        int temp=0;
        temp=b;
        b=a;
        a=temp;
    }
    /**
     * 冒泡排序：降序
     * @param data
     * @return
     */
    public static void bubbleSortI(int[] data){
        if (data.length==0){
            System.out.println("数组为空");
            return;
        }
        int len=data.length;
        for (int i = 0; i < len; ++i) {
            // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            boolean flag = false;
            //此处你可能会疑问的j<n-i-1，因为冒泡是把每轮循环中较大的数飘到后面，
            for (int j = 0; j < len - i - 1; ++j) {
                // 数组下标又是从0开始的，i下标后面已经排序的个数就得多减1，总结就是i增多少，j的循环位置减多少
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag = true;
                }
            }
            //没有数据交换，数组已经有序，退出排序
            if (!flag) break;
        }

    }
    public static void bubbleSortII(int[] data){
        if (data.length==0){
            return;
        }
        int len=data.length;
        int n=len;
        int lastExchangeIndex=0;
        while (n>0){
            lastExchangeIndex=0;
            for (int i=0;i<n-1;i++){
                if (data[i]>data[i+1]){
                    int temp=data[i];
                    data[i]=data[i+1];
                    data[i+1]=temp;
                    lastExchangeIndex=i+1;
                }
            }
            n=lastExchangeIndex;

        }

    }

    public static void main(String[] args) {
        int[] data={3,6,5,9,7,10,1};
        bubbleSortII(data);
        for (int a:data){
            System.out.println(a);
        }

    }
}
