import java.util.HashMap;

/**
 * @author chendan
 * @date 2019/6/26 10:38
 */
public class MincostTickets {
    public static int threeMax(int a,int b, int c){
        int temp=0;
        temp=a<b?a:b;
        temp=c<temp?c:temp;
        return temp;

    }

    /**
     * cost不是严格按照递增的顺序
     * @param days
     * @param costs
     * @return
     */
    public static int mincostTickets(int[] days, int[] costs) {
        if (days.length<=0||days.length>365||costs.length<0||costs.length>3){
            return 0;
        }
        int len=days[days.length-1];
        int[] res=new int[len+1];
        for (int k=0;k<=len;k++){
            res[k]=0;
        }
        if (days.length==1){
            return 2;
        }
        for (int j=0;j<=days.length-1;j++){
            //如果长度只有1
            if (j==0){
                int position=days[j];
                res[position]=threeMax(costs[0],costs[1],costs[2]);
            }else {
                int position=days[j-1];
                int a=res[position]+costs[0];
                int b=1000;
                int c=1000;
                int position7=days[j]-7;
                int position30=days[j]-30;
                if (position7>0){
                    while (res[position7]==0&&position7>0){
                        position7--;
                    }
                    b=res[position7]+costs[1];
                }else {
                    b=costs[1];
                }
                res[days[j]]=threeMax(a,b,c);
                if (position30>0){
                    while (res[position30]==0&&position7>0){
                        position30--;
                    }
                    c=res[position30]+costs[2];
                }else {
                    c=costs[2];
                }
                res[days[j]]=threeMax(a,b,c);

            }

        }
        return res[len];
    }

    public static void main(String[] args) {
        int[] days={1,4,6,7,8,20};
        int[] costs={7,2,15};
        System.out.println(mincostTickets(days,costs));


    }
}
