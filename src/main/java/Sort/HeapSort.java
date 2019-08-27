package Sort;

/**
 * @author chendan
 * @date 2019/8/21 9:41
 */
public class HeapSort {
    /**
     * 构建小顶堆
     * @param list
     */
    public static void headSort(int[] list) {
        //构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = (list.length) / 2 - 1; i >= 0; i--) {
            headAdjust(list, list.length, i);
        }
        //排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = list.length - 1; i >= 1; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            headAdjust(list, i, 0);
        }
    }
    //把list中i位置通过调整使其满足小顶堆
    public static void headAdjust(int[] list, int len, int i) {
        //index表示非叶子节点i的左孩子
        int k = i, temp = list[i], index = 2 * k + 1;
        while (index < len) {
            //非叶子节点i还有右孩子并且大于左孩子
            if (index + 1 < len) {
                //找出左右孩子中更大数的位置
                if (list[index] < list[index + 1]) {
                    index = index + 1;
                }
            }
            if (list[index] > temp) {
                list[k] = list[index];
                k = index;
                index = 2 * k + 1;
            } else {
                break;
            }
        }
        list[k] = temp;
    }

    public static void main(String[] args) {
        int[] arr={6,5,8,7,3,2,1,4};
        headSort(arr);
        //输出结果是降序
        for (int i:arr){
            System.out.println(i);
        }


    }
}
