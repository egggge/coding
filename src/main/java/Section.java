import java.util.*;

/**
 * @author chendan
 * @date 2019/6/30 11:19
 */
public class Section {
    public static String genMinStr(String s){
        StringBuffer stringBuffer=new StringBuffer();
        char[] chars=s.toCharArray();
        int i=0;
        int j=chars.length-1;
        while (i<j){
            if (chars[i]<chars[j]){
                stringBuffer.append(chars[i]);
                i++;
            }
            else {
                stringBuffer.append(chars[j]);
                j--;
            }
        }
        stringBuffer.append(chars[i]);
        return stringBuffer.toString();
    }
    //不能排序，针对的就是给的数据序列
    public static void main(String[] args) {

        System.out.println(genMinStr("acdbcb"));
//        Scanner in = new Scanner(System.in);
//        int len = in.nextInt();
//        int[] a = new int[len];
//        for (int i = 0; i < a.length; i++)
//            a[i] = in.nextInt();
//
//        int dpminLast = a[0],dpminNow = a[0];
//        int dpsumLast = a[0],dpsumNow = a[0];
//        int temp = dpminNow*dpsumNow;
//        for (int i = 0; i < a.length; i++) {
//            dpminLast = a[i];
//            dpsumLast = a[i];
//            if(temp < a[i]*a[i]){
//                temp = a[i]*a[i];
//            }
//            for (int j = i + 1 ; j < a.length; j++) {
//                //用临时变量记录，因为只需要两个变量的值呀
//                dpminNow = a[j] < dpminLast ? a[j] : dpminLast;
//                dpsumNow = a[j] + dpsumLast;
//                if(temp < dpminNow*dpsumNow){
//                    temp = dpminNow*dpsumNow;
//                }
//                dpminLast = dpminNow;
//                dpsumLast = dpsumNow;
//            }
//        }
//        System.out.println(temp);
   }
}
