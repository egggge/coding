import java.util.*;

/**
 * @Author: egg
 * @Date: 2019-05-23 11:08
 */
public class StringArrange {
    private static Set<String> set;
    static {
        set=new HashSet<String>();
        set.add("1");
        int num=1;
        while (true){
            num<<=1;
            System.out.println(num);
            char[] s= Integer.toString(num).toCharArray();
            //设定上界
            if (s.length>10){break;}
            System.out.println(s);
            Arrays.sort(s);
            set.add(new String(s));
        }
    }
    /**
     * 输入数字，排序，是否为2的幂
     * @param N
     * @return
     */
    public boolean reorderedPowerOf2(int N) {
        char[] chars=Integer.toString(N).toCharArray();
        Arrays.sort(chars);
        String s=new String(chars);
        return set.contains(s);


    }

    /**
     *
     * @param strArrs
     * @param i
     */

    public void permutateSequence(char[] strArrs,int i){
        char temp;
        if(strArrs==null||i>strArrs.length||i<0){
            return;
        }
        //遍历完整个字符串,打印
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

    /**
     * 字符串的全排列
     * 1.
     * @param arrayA
     * @param start
     * @param end
     */
    public void recursionArrange(char[] arrayA,int start,int end){
        if(end < 1){
            return;
        }
        //这个递归没有返回值，直接打印，
        if(start == end){
           StringBuffer s=new StringBuffer();
            for(int i = 0;i < arrayA.length;i++){
                s.append(arrayA[i]);
            }
            System.out.println(s.toString());
        }
        else{
            for(int i = start;i <= end;i++){
                swap(arrayA,i,start);
                recursionArrange(arrayA,start+1,end);
                swap(arrayA,i,start);
            }
        }

    }
    //交换数组m位置和n位置上的值
    public void swap(char[] arrayA,int m,int n){
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
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

    /**
     * 字符串的组合
     * @param chs
     */

    public static void combiantion(char chs[]){
        if(chs==null||chs.length==0){
            return ;
        }
        List<Character> list=new ArrayList();
        for(int i=1;i<=chs.length;i++){
            combine(chs,0,i,list);
        }
    }

//从字符数组中第begin个字符开始挑选number个字符加入list中

    public static void combine(char []cs,int begin,int number,List<Character> list){
        if(number==0){
            System.out.println(list.toString());
            return ;
        }
        if(begin==cs.length){
            return;
        }
        //第一种是加入第一个字符，再选择number-1
        list.add(cs[begin]);
        combine(cs,begin+1,number-1,list);
        //第二种不要第一个字符，直接选择number个字符
        list.remove((Character)cs[begin]);
        combine(cs,begin+1,number,list);
    }







    public static void main(String[] args) {
        StringArrange stringArrange = new StringArrange();
        String A = "dac";
        String B = "abcd";
        char[] arrayA = A.toCharArray();
//        char[] arrayB = B.toCharArray();
//        int[] ints ={1,2,3};
        stringArrange.recursionArrange(arrayA,0,arrayA.length-1);
//        if (stringArrange.reorderedPowerOf2(46)){
//            System.out.println(1);
//        }



    }
}
