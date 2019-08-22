import java.util.HashMap;

/**
 * @author chendan
 * @date 2019/5/29 20:22
 */
public class longestSubWithoutDup {
    public int longest(String s){
        char[] chars=s.toCharArray();
        int curLength=0;
        int maxLength=0;

        int[] position=new int[26];
        //用坐标代替字母
        for (int i=0;i<26;i++){
            position[i]=-1;
        }

        for (int i=0;i<chars.length;i++){
            int prevIndex=position[chars[i]-'a'];
            //字符从未出现和d>f(i-1)。都可以让当前最长长度+1
            if (prevIndex<0||i-prevIndex>curLength){
                ++curLength;
            }
            //d<f(i)表示字符出现在最长字符里面
            //并且这个上一次长度>max，则max=cur
            else {
                //只有出现相同字符才需要更新当前最大值
                if (curLength>maxLength){
                    maxLength=curLength;
                }
                curLength=i-prevIndex;
            }
            position[chars[i]-'a']=i;
        }
        if (curLength>maxLength){
            maxLength=curLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s="cabcacfr";
        longestSubWithoutDup test = new longestSubWithoutDup();
        System.out.println(test.longest(s));
        System.out.println('c'-'a');
    }
}
