import java.util.*;

/**
 * @Author: egg
 * @Date: 2019-06-04 20:56
 */
public class test {
    public static int lastWordLen(String s) {
        if (s == null) {
            return 0;
        } else if (s.trim().equals("")) {
            return 0;
        } else {
            String[] l = s.split(" ");
            return l[l.length - 1].toCharArray().length;
        }

    }

    public static int containWord(String s1, String s2) {
        char[] s = s1.toCharArray();
        char[] target = s2.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == target[0]) {
                count++;
            }
        }
        return count;

    }


    public static void sortAscend(Integer[] a) {
        Arrays.sort(a, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        });
    }

    public static void quickSort(int[] arr, int start, int len) {
        if (arr != null && len != 0) {
            int lo = start;
            int hi = len;
            int target = arr[start];
            while (lo < hi) {
                while (arr[hi] >= target && lo < hi) {
                    hi--;
                }
                if (lo < hi && arr[hi] < target) {
                    int temp = arr[hi];
                    arr[hi] = target;
                    arr[lo] = temp;
                    lo++;
                }
                while (lo < hi && target >= arr[lo]) {
                    lo++;
                }
                if (lo < hi && arr[lo] > target) {
                    int temp = arr[lo];
                    arr[lo] = target;
                    arr[hi] = temp;
                    hi--;
                }
            }
            if ((lo - 1) > start) {
                quickSort(arr, start, lo - 1);
            }
            if ((hi + 1) < len - 1) {
                quickSort(arr, hi + 1, len);
            }

        }
    }


    public static void main(String[] args) {
        TreeMap<Integer,Integer> map=new TreeMap<Integer, Integer>();
        int i=10;
        while (i>0){
            map.put(i,i);
            i--;
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }





//        int[] arr={10,20,40,32,67,8,10,9};
//        quickSort(arr,0,arr.length-1);
//        for (int i:arr){
//            System.out.println(i);
//        }
        //System.out.println(containWord("AGA5 TFG3L","A"));


    }
}










