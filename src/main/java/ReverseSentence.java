import java.util.Arrays;
import java.util.List;

/**
 * @author chendan
 * @date 2019/6/18 15:47
 */
public class ReverseSentence {
    /**
     * 翻转数字
     * 考虑不要溢出
     * @param x
     * @return
     */
    public static int reverseII(int x) {
        int result = 0;
        while (x != 0) {
            // x % 10 可以取到 x 最后一位的值，即此时 pop 是 x 的最后一位，也就是新值的第一位
            int pop = x % 10;
            // x 的位数少了最后一位
            x = x / 10;

            // 由于后续运算 result = result * 10 + pop
            // 如果 result 的值大于 Integer.MAX_VALUE / 10 ，那么一定会溢出
            // 如果 result 的值等于 Integer.MAX_VALUE / 10，那么 pop 的值如果大于 Integer.MAX_VALUE % 10 也会溢出
            // 相反的，result 的值小于 Integer.MIN_VALUE / 10 ，那么一定会溢出
            // 如果 result 的值等于 Integer.MIN_VALUE / 10，那么 pop 的值如果小于于 Integer.MIN_VALUE % 10 也会溢出

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
    public void reverseSentence(String s){
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
        reverseSentence.leftRotateString("abcdefg",6);
    }

}
