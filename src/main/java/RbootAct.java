import java.util.Arrays;
import java.util.List;

/**
 * @Author: egg
 * @Date: 2019-05-06 15:37
 */
public class RbootAct {
    /**
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int moveCount(int threshold,int rows,int cols){
        //异常情况
        if (threshold<0||rows<=0||cols<=0){
            return 0;
        }
        //矩阵不需要用二维数组表示
        boolean[] visited = new boolean[rows*cols];
        for (boolean v:visited){
            v=false;
        }
        int count = moveCountCore(threshold,rows,cols,0,0,visited);
        return count;

    }
    public int moveCountCore(int threshold,int rows,int cols,int row,int col,boolean[] visited){
        int count=0;
        if (check(threshold,rows,cols,row,col,visited)){
            visited[row*cols+col]=true;
            count=1+moveCountCore(threshold,rows,cols,row+1,col,visited)
                    +moveCountCore(threshold,rows,cols,row-1,col,visited)
                    +moveCountCore(threshold,rows,cols,row,col+1,visited)
                    +moveCountCore(threshold,rows,cols,row,col-1,visited);
        }
        return count;


    }

    /**
     * 检查数字是否出界
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @return
     */

    public boolean check(int threshold,int rows,int cols,int row,int col,boolean[] visited){
        if (row>=0&&row<rows&&col>=0&&col<cols&&getDigitSum(row)+getDigitSum(col)<=threshold&&!visited[row*cols+col]){
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * 一个数字的数位之和
     * @param number
     * @return
     */
    public int getDigitSum(int number){
        int sum=0;
        while (number>0){
            sum+=number%10;
            number/=10;
        }
        return sum;
    }
    public static void main(String[] args){
        RbootAct rbootAct = new RbootAct();
        System.out.println(rbootAct.moveCount(8,8,8));

    }
}
