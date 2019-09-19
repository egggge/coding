import java.util.HashMap;

/**
 * @author chendan
 * @date 2019/5/29 20:22
 */
public class longestSubWithoutDup {
    /**
     * 这里面包含了大写，小写，数字，其他字符
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s==null){
            return 0;
        }
        //int[] position=new int[26];
        HashMap<Character,Integer> position=new HashMap<Character, Integer>();
        char[] arr=s.toCharArray();
        int max=0;
        int cur=0;
        for (int i=0;i<arr.length;i++){
            //这个字符出现过
            if (position.containsKey(arr[i])){
                int d=i-position.get(arr[i]);
                if (d<=cur){
                    cur=d;
                }else {
                    cur++;
                }
            }else {
                cur++;
            }
            position.put(arr[i],i);
            max=Math.max(max,cur);
        }

        return max;

    }
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

    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length()==0){
            return s;
        }
        int len=s.length();
        int left=0;
        int right=0;
        //布尔矩阵初始化默认为false
        boolean[][] dp=new boolean[len][len];
        //从倒数第二个开始
        for (int i=len-2;i>=0;i--){
            dp[i][i]=true;
            for (int j=i+1;j<len;j++){
                if (s.charAt(i)==s.charAt(j)&&(j-i<3||dp[i+1][j-1])){
                    dp[i][j]=true;
                    if ((j-i)>(right-left)){
                        left=i;
                        right=j;
                    }
                }
            }
        }
        return s.substring(left,right+1);

    }

    public static void main(String[] args) {
        String s="cabcacfr";
        longestSubWithoutDup test = new longestSubWithoutDup();
        System.out.println(test.longestPalindrome(s));
        System.out.println('c'-'a');
    }
}
