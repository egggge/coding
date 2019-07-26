/**
 * 动态规划
 * @author chendan
 * @date 2019/5/28 20:44
 */
public class GetMaxValue {
    public int getMaxGift(int[] values,int rows,int cols){
        if (values==null||rows<=0||cols<=0){
            return 0;
        }
        int[][] maxValues = new int[rows][cols];
        for (int i=0;i<rows;++i){
            for (int j=0;j<cols;++j){
                int left=0;
                int down=0;

                if (i>0){
                    down=maxValues[i-1][j];
                }
                if (j>0){
                    left=maxValues[i][j-1];
                }
                maxValues[i][j]=Math.max(down,left)+values[i*cols+j];
            }
        }
        int maxValue = maxValues[rows-1][cols-1];
        return maxValue;
    }

    public int getMaxGiftBetter(int[] values,int rows,int cols){
        if (values==null){
            return 0;
        }
        int[] maxValues = new int[cols];
        for (int i=0;i<rows;++i){
            for (int j=0;j<cols;++j){
                int left=0;
                int down=0;
                if (j>0){
                    left=maxValues[j-1];
                }
                if (i>0){
                    down=maxValues[j];
                }
                maxValues[j]=Math.max(left,down)+values[i*cols+j];
            }
        }
        int maxValue=maxValues[cols-1];
        return maxValue;

    }
}
