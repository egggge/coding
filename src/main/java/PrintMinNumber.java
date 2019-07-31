import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: egg
 * @Date: 2019-07-30 20:22
 */
public class PrintMinNumber {
    /**
     * 把数组排成最小的数
     * 重点掌握比较器的使用
     * @param numbers
     * @return
     */
    public static String printMinNum(int[] numbers){
        int n=numbers.length;
        String s="";
        ArrayList<Integer> list=new ArrayList<Integer>();

        for (int i:numbers){
            list.add(i);
        }

        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                String s1=o1+""+o2;
                String s2=o2+""+o1;
                //升序，代表原数组按照降序的排序
                System.out.println(s1+","+s2+","+s1.compareTo(s2));
                return s1.compareTo(s2);
            }
        });
        for (int j:list){
            s+=j;
        }
        return s;


    }

    public static void main(String[] args) {
        int[] arr={3,12,121,4};
        System.out.println(printMinNum(arr));
    }
}
