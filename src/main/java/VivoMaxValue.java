/**
 * @Author: egg
 * @Date: 2019-06-04 20:25
 * 输入：总金额：1000+礼物单价+对应礼物热度
 */
import java.*;
public class VivoMaxValue {
    /**
     *动态规划
     * @param m 你拿到的钱
     * @param n 商品物品总量
     * @param w 商品的热度
     * @param p 商品的价值
     * @return
     */

    public  int BackPack_Solution(int m, int n, int[] w, int[] p) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            c[i][0] = 0;
        for (int j = 0; j < m + 1; j++)
            c[0][j] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //i表示物品个数
                //j表示背包总容量
                if (w[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1]))
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    else
                        c[i][j] = c[i - 1][j];
                } else
                    c[i][j] = c[i - 1][j];
            }
        }
        return c[n][m];
    }


    public static void main(String[] args) {
        int total=1000;
        int[] hot={6,10,3,4,5,8};
        int[] price={200,600,100,180,300,450};
        VivoMaxValue vivoMaxValue = new VivoMaxValue();
        System.out.println(vivoMaxValue.BackPack_Solution(total,hot.length,price,hot));
    }

}
