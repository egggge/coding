import java.util.Arrays;
import java.util.List;

/**
 * @author chendan
 * @date 2019/6/18 15:47
 */
public class ReverseSentence {
    /**
     * 翻转数字
     * 考虑溢出
     * @param x
     * @return
     */
    public  int reverseII(int x) {
        int result = 0;
        while (x != 0) {
            // x % 10 可以取到 x 最后一位的值，即此时 pop 是 x 的最后一位，也就是新值的第一位
            int pop = x % 10;
            // x 的位数少了最后一位
            x = x / 10;

            // 由于后续运算 result = result * 10 + pop
            // 如果 result 的值大于 Integer.MAX_VALUE / 10 ，那么一定会溢出
            // 如果 result 的值等于 Integer.MAX_VALUE / 10，那么 pop 的值如果大于 Integer.MAX_VALUE % 10 也会溢出
            // 相反的，result 的值小于 Integer.MIN_VALUE / 10 ，那么一定会溢出.因为后面至少还有一位
            // 如果 result 的值等于 Integer.MIN_VALUE / 10，那么 pop 的值如果小于 Integer.MIN_VALUE % 10 也会溢出

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                result = 0;
                return result;
            } else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                result = 0;
                return result;
            }
            result = result * 10 + pop;
        }
        return result;
    }

    /**
     * f翻转字符串
     * 注意trim()去除字符串首尾空格
     * @param str
     * @return
     */
    public String reverseSentence(String str) {
        if (str == null) {
            return null;
        } else if (str.trim().equals("")) {
            return str;
        } else {
            String[] list = str.split(" ");
            StringBuffer stringBuffer = new StringBuffer();

            int i = list.length - 1;
            while (i > 0) {
                stringBuffer.append(list[i] + " ");
                i--;

            }
            stringBuffer.append(list[i]);
            return stringBuffer + "";


        }
    }

    /**
     * 翻转字符串
     * 没有上一个考虑周全
     * @param s
     */
    public void reverseSentenceII(String s){
        List<String> sList= Arrays.asList(s.split(" "));
        for (int j=sList.size()-1;j>=0;j--){
            System.out.printf(sList.get(j)+" ");
        }


    }


    public void leftRotateString(String s,int n){
        if (s==null){
            throw new RuntimeException();
        }
        if (n>s.length()){
            throw new RuntimeException();
        }
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(s.substring(n));
        stringBuffer.append(s.substring(0,n));
        System.out.println(stringBuffer);


    }


    public static void main(String[] args) {
        ReverseSentence reverseSentence=new ReverseSentence();
        //reverseSentence.reverseSentence("I Love u.");
        //reverseSentence.leftRotateString("abcdefg",6);
        System.out.println(reverseSentence.reverseII(123456));
    }

}
