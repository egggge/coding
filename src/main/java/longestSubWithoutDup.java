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
            //若char[1]第一次出现，那么prevIndex=-1
            int prevIndex=position[chars[i]-'a'];
            if (prevIndex<0||i-prevIndex>curLength){
                ++curLength;
            }
            else {
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
