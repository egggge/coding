import java.util.Arrays;
import java.util.List;

/**
 * @author chendan
 * @date 2019/6/18 15:47
 */
public class ReverseSentence {
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
