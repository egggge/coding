import java.util.*;

/**
 * @author chendan
 * @date 2019/8/3 20:41
 */
public class HauWei {
    /**
     * 4
     * 2 5 6 13
     * 找到最大的伴侣素数
     * output:2
     */
    public static void compsnySu(){
        //存奇数
        ArrayList<Integer> evens = new ArrayList<Integer>();
        ArrayList<Integer> odds = new ArrayList<Integer>();
        int[] num={2,4,1,6,3,9};
        for (int i = 0; i < 6; i++) {
            if(num[i]%2!=0){
                evens.add(num[i]);
            }else {
                odds.add(num[i]);
            }

        }
        //最大的素数对也就是跟奇数的个数相等，因为素数一定是一个偶数加一个奇数
        int result=0;
        int matched[]=new int[evens.size()];
        for(int i=0;i<odds.size();i++){
            //为每个汉子建立一个妹子列表
            int used []=new int[evens.size()];
            if(find(odds.get(i),used,matched,evens)){
                result++;
            }
        }
        System.out.println(result);

    }
    private static boolean find(Integer integer, int[] used, int[] matched, ArrayList<Integer> evens) {
        for(int j=0;j<evens.size();j++){
            if(isPrim(integer, evens.get(j)) && used[j]==0){
                used[j]=1;
                if(matched[j]==0 || find(matched[j], used, matched, evens)){
                    matched[j]=integer;
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean isPrim(int num1, int num2) {
        int sum = num1 + num2;
        for (int i = 2; i < sum; i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * 键值对排序，学会用treemap(类)
     */
    public void pairNumSort(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int len=Integer.parseInt(sc.nextLine());
            TreeMap<Integer,Integer> map=new TreeMap<Integer, Integer>();
            for (int i=len;i>0;i--){
                String s=sc.nextLine();
                int key=Integer.parseInt(s.split(" ")[0]);
                int value=Integer.parseInt(s.split(" ")[1]);
                if(!map.containsKey(key)){
                    map.put(key,value);
                }else{
                    int temp=map.get(key)+value;
                    map.put(key,temp);
                }
            }
            StringBuilder builder = new StringBuilder();
            for(SortedMap.Entry<Integer,Integer>e:map.entrySet()){
                builder.append(e.getKey()).append(" ").append(e.getValue()).append("\r");
            }
            System.out.println(builder.toString());


        }
    }

    /**
     * s输入：978663
     * 输出：37879
     * 避免hashmap的排序，使用LinkehHashMap
     */

    public void reBuildNum(){
        Scanner sc = new Scanner(System.in);
        //hashmap也是自动排序
        HashMap<Integer,Integer> hashMap=new LinkedHashMap<Integer, Integer>();
        while(sc.hasNext()) {
            int n = sc.nextInt();
            while (n!=0){
                int temp=n%10;
                n=n/10;
                if (!hashMap.containsKey(temp)){
                    hashMap.put(temp,1);
                }
            }
            StringBuffer str=new StringBuffer();
            for (Integer key:hashMap.keySet()){
                str.append(key);
            }
            System.out.println(str.toString());

        }
    }
    /**
     * 找出字符的asii码
     */
    public void getACSII(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i = 0; i < s.length(); i++){
            System.out.println((int)s.charAt(i));
        }
        sc.close();

    }

    /**
     * 购物单问题（为什么不能写else）
     * @param N 可花费的最大资金
     * @param m m种物品选择
     * @param w 每个物品的权重
     * @param v 每个物品的价格
     * @param p 判断是否是主件（==0）还是附件
     * @return
     */

    public static int getMaxValue(int N,int m,int[] w,int[] v,int[] p){
        int[][] res=new int [m+1][N+1];
        //i表示第几个物品
        for(int i=1;i<=m;i++){
            //j表示当前拥有资金
            for(int j=0;j<=N;j++){
                //p[1]表示第一个物品是否为主件
                if(p[i]==0){
                    //v[1]表示第一个物品的价格
                    if(v[i]<=j){
                        res[i][j]=Math.max(res[i-1][j],res[i-1][j-v[i]]+v[i]*w[i]);
                    }
                }else{
                    if(v[i]+v[p[i]]<=j){
                        res[i][j]=Math.max(res[i-1][j],res[i-1][j-v[i]-v[p[i]]]+v[i]*w[i]+v[p[i]]*w[p[i]]);
                    }
                }
            }
        }
        return res[m][N];

    }
    public void positionMove(){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int LR=0;
            int UD=0;
            String[] input=sc.nextLine().split(";");
            for(String s:input){
                int l=s.length();
                if(l<=3){
                    char c=s.charAt(0);
                    String regex = "^[0-9]{1,2}$";
                    if (s.substring(1,l).matches(regex)){
                        int m=Integer.parseInt(s.substring(1,l));
                        if(c=='A'){
                            LR-=m;
                        }else if(c=='D'){
                            LR+=m;
                        }else if(c=='W'){
                            UD+=m;
                        }else if(c=='S'){
                            UD-=m;
                        }

                    }

                }

            }
            StringBuffer result=new StringBuffer();
            result.append(LR);
            result.append(",");
            result.append(UD);
            System.out.println(result.toString());

        }
    }

    /**
     * 任意交换字符串中两个字母的位置，找到此单词
     * 1.将字符串化解为字符数组，循环遍历字典
     * 2.当字符串有重复字母，其全排列有重复的。可以用tessset去重
     */
    public void findBroWord(){

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            //一个一个输入
            int num = in.nextInt();
            String[] s = new String[num];
            int count = 0;
            for(int i = 0;i<num;i++){
                s[i] = in.next();
            }
            String key = in.next();
            char[] keyChar = key.toCharArray();
            Arrays.sort(keyChar);
            int no = in.nextInt();//第几个
            ArrayList<String> list = new ArrayList<String>();
            //笔者思想就是遍历字典，避免生成字符串的全排列
            for(int i = 0;i<num;i++){
                int c = check(key,s[i],keyChar);
                count += c;
                if(c==1){
                    list.add(s[i]);
                    System.out.println(s[i]);

                }

            }
            System.out.println(count);
            Collections.sort(list);
            if(count>=no)
                System.out.println(list.get(no-1));
        }
    }
    private static int check(String key,String word,char[] keyChar){
        if(key.equals(word)||key.length()!=word.length())
            return 0;
        char[] wordChar = word.toCharArray();
        Arrays.sort(wordChar);
        return Arrays.equals(keyChar, wordChar)?1:0;
    }

    /**
     * 注意16进制的转换
     */
    public void covert(){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            StringBuffer res=new StringBuffer();
            StringBuffer result=new StringBuffer();
            String[] s=sc.nextLine().split(" ");
            int n= Integer.parseInt(s[0]);
            int count=0;
            for (int i=1;i<=n;i++){
                //System.out.println(s[i]);
                if (s[i].equals("A")){
                    res.append("12"+" "+"34"+" ");
                    count+=2;
                }else if (s[i].equals("B")){
                    res.append("AB"+" "+"CD"+" ");
                    count+=2;
                }else {
                    res.append(s[i]+" ");
                    count++;
                }
                //System.out.println(count);

            }
            //System.out.println(count);
            String t=Integer.toHexString(count).toUpperCase();
            result.append(t+" ");
            result.append(res.toString());
            System.out.println(result.toString().trim());

        }
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            int N=Integer.parseInt(s.split(" ")[0]);
            int m=Integer.parseInt(s.split(" ")[1]);
            int i=1;
            int[] w=new int[m+1];
            int[] v=new int[m+1];
            int[] p=new int[m+1];
            while (i<=m){
                String input=sc.nextLine();
                v[i]=Integer.parseInt(input.split(" ")[0]);
                w[i]=Integer.parseInt(input.split(" ")[1]);
                p[i]=Integer.parseInt(input.split(" ")[2]);
                i++;
            }
            int result=getMaxValue(N,m,w,v,p);
            System.out.println(result);
        }
    }
}
