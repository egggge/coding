package DynamicPlanning;

import java.util.Arrays;

/**
 * @author chendan
 * @date 2019/6/26 16:42
 */
public class CoinChange {


    public static int coinChange(int[] coins, int amount) {
        if (amount<0||coins.length<1){
            return -1;
        }
        int[] res=new int[amount+1];
        //res[0]=0;
        for (int j=1;j<=amount;j++){
            int min=Integer.MAX_VALUE;
            for (int c:coins){
                int temp=j-c;
                if (temp>=0&&res[temp]!=-1){
                    min=Math.min(min,res[temp]);
                }
                res[j]=min==Integer.MAX_VALUE?-1:min+1;
            }

        }
        return res[amount];

    }

    public static void main(String[] args) {

        int[] coins={186,419,83,408};
        int[] coin={1};
        int count=6249;
        int counts=0;
        System.out.println(coinChange(coin,counts));
    }
}
