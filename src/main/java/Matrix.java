/**
 * @Author: egg
 * @Date: 2019-07-09 20:25
 */
public class Matrix {
    /**
     * 建立矩阵，找最长对角线
     * @param m
     * @param n
     * @return
     */
    public static int maxSubStr(String m,String n){
        if (m==null||n==null){
            return 0;
        }
        char[] mChar=m.toCharArray();
        char[] nChar=n.toCharArray();
        int rows=mChar.length;
        int cols=nChar.length;
        int[][] records=new int[rows][cols];
        int max=0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (mChar[i]==nChar[j]){
                    if (i>0&&j>0){
                        records[i][j]=records[i-1][j-1]+1;
                        max=records[i][j]>max?records[i][j]:max;

                    }else{
                        records[i][j]=1;
                    }
                }else {
                    records[i][j]=0;
                }
            }
        }
        return max;
    }



}
