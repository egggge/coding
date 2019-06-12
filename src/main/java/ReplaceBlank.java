/**
 * @author chendan
 * @date 2019/6/5 9:20
 */
public class ReplaceBlank {
    /**
     * java不可以改变字符串
     * 只能用stringbuilder
     * @param s
     */
    public void replaceBlank(String s){
        if (s==null){
            return;
        }
        char[] chars=s.toCharArray();
        StringBuffer stringBuffer=new StringBuffer();
        for (char c:chars){
            if (c==' '){
                stringBuffer.append("%20");
            }
            else {
                stringBuffer.append(c);

            }
        }
        System.out.println(stringBuffer.toString());



    }

    public static void main(String[] args) {
        ReplaceBlank replaceBlank = new ReplaceBlank();
        String s="We are happy";
        replaceBlank.replaceBlank(s);

    }
}
