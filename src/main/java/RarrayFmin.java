/**
 * @Author: egg
 * @Date: 2019-05-06 08:39
 */
public class RarrayFmin {
    /**
     * 如果旋转了0个数字
     * 如果三个指标下的数字都相等
     * @param array
     * @return
     */
    public static int findMin(int[] array){
        int lo=0;
        int hi=array.length-1;
        int mid=0;
        //如果第一个递增数列不大于第二个递增数列，那么说明没有进行旋转
        while (array[lo]>=array[hi]){
            if ((hi-lo)==1){
                mid=hi;
                break;
            }
            mid=(lo+hi)/2;
            //三个数字都相同，则无法确定目标在哪个递增数列
            if (array[lo]==array[hi]&&array[lo]==array[mid]){
                return minInOrder(array,lo,hi);


            }
            //mid位于第二个递增数列，目标在它自己或者前面
            else if (array[mid]<=array[lo]){
                hi=mid;

            }
            //mid位于第一个递增数列，且目标在它后面
            else if (array[mid]>=array[lo]){
                lo=mid;

            }

        }
        return array[mid];
    }
    public static int minInOrder(int[] array,int lo,int hi){
        int result = array[lo];
        for (int i=lo+1;i<=hi;i++){
            if (result>array[i]){
                result = array[i];
            }

        }
        return result;
    }
    public static void main(String[] args){
        int[] data = {1,0,1,1,1,1};
        System.out.println(findMin(data));

    }

}
