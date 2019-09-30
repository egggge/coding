package DynamicPlanning;

/**
 * @Author: egg
 * @Date: 2019-09-09 16:34
 */
public class numPermsDISequence {
    /**
     * DI序列的有效排列
     * @param a
     * @return
     */
    public static int count(int[] a) {
        int res = 0, n = a.length;
        int M = 1000000007;
        int[][] dp1=new int[n+1][n+1];
        dp1[0][0]=1;
        //这个是从0开始计算的
        for (int i = 1; i <=n ; i++) {
            for (int j=0;j<=i;j++){
                int temp = a[i - 1];
                //1表示降序
                if (temp == 1) {
                    //降序：加的数字大于等于最后一个数字（【j,i-1】）
                    for (int k = j; k <= i-1; ++k) {
                        dp1[i][j]+=dp1[i-1][k];
                        dp1[i][j]%=M;
                    }
                }else if (temp == 0) {
                    //升序，加的数字《当前的数字（j）
                    for (int k = 0; k <= j-1; ++k) {
                        dp1[i][j]+=dp1[i-1][k];
                        dp1[i][j]%=M;
                    }
                }
            }
        }
        //将最后一行加起来就是最后的结果
        for (int i=0;i<=n;i++){
            res=(res+dp1[n][i])%M;
        }
        return res;
    }
}
