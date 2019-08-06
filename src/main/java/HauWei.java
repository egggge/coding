import java.util.*;

/**
 * @author chendan
 * @date 2019/8/3 20:41
 */
public class HauWei {
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
