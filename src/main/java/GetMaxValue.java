/**
 * 动态规划
 * @author chendan
 * @date 2019/5/28 20:44
 */
public class GetMaxValue {
    public static int maxGiftInMatrix(int[] arr,int rows,int cols){

        if (arr.length!=0){
            int count=arr[0];
            int i=0;
            int row=0;
            int col=0;
            int left=0;
            int down=0;
            //这个条件满足不会数组越界
            while (col<cols&&row<rows&&i<=(cols+rows-2)){
                if (col+1==cols){
                    left=0;
                }else {
                    left=arr[rows*row+col+1];
                }
                if (row+1==rows){
                    down=0;
                }else {
                    down=arr[rows*(row+1)+col];
                }
                if (left>down){
                    count+=left;
                    col++;
                }else {
                    count+=down;
                    row++;
                }
                i++;

            }
            return count;

        }
        return 0;

    }
    public static int getMaxGift(int[] values,int rows,int cols){
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

    public static int getMaxGiftBetter(int[] values,int rows,int cols){
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

    public static void main(String[] args) {
        int[] arr={1,10,70,8,12,1,10,6,5,7,15,11,3,7,20,5};
        System.out.println(maxGiftInMatrix(arr,4,4));

    }
}
