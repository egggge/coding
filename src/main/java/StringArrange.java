import java.util.ArrayList;
import java.util.List;

/**
 * @Author: egg
 * @Date: 2019-05-23 11:08
 */
public class StringArrange {
    public void permutateSequence(char[] strArrs,int i){
        char temp;
        if(strArrs==null||i>strArrs.length||i<0){
            return;
        }
        //遍历完整个字符串，可以打印
        else if(i==strArrs.length){
            System.out.println(strArrs);
        }
        else{
            for(int j=i;j<strArrs.length;j++){
                temp = strArrs[j];
                strArrs[j] = strArrs[i];
                strArrs[i] = temp;
                permutateSequence(strArrs, i+1);
                temp = strArrs[j];
                strArrs[j] = strArrs[i];
                strArrs[i] = temp;
            }
        }
    }
    public void recursionArrange(char[] arrayA,int start,int end){
        if(end <= 1){
            return;
        }
        if(start == end){
            for(int i = 0;i < arrayA.length;i++){
                System.out.print(arrayA[i]);
            }
            System.out.println();
        }
        else{
            for(int i = start;i <= end;i++){
                swap(arrayA,i,start);
                recursionArrange(arrayA,start+1,end);
                swap(arrayA,i,start);
            }
        }

    }

    /**
     * 回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtrack(list, new ArrayList<Integer>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<Integer>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                // element already exists, skip
                if(tempList.contains(nums[i])) {continue;}
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    //交换数组m位置和n位置上的值
    public void swap(char[] arrayA,int m,int n){
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }

    public static void main(String[] args) {
        StringArrange stringArrange = new StringArrange();
        String A = "abc";
        String B = "abcd";
        char[] arrayA = A.toCharArray();
        char[] arrayB = B.toCharArray();
        int[] ints ={1,2,3};
        //stringArrange.recursionArrange(arrayA,0,arrayA.length-1);
        //stringArrange.permutateSequence(arrayB,0);
        stringArrange.permute(ints);

    }
}
