import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chendan
 * @date 2019/8/23 15:49
 */
public class TravelMartrix {
    public static int col;
    public static int row;

    public static void jishu(int[] arr,int rows,int cols){
        col=0;
        while (col<cols){
            System.out.printf(arr[row*rows+col]+" ");
            if (row<rows-1){
                System.out.printf(arr[(1+row)*rows+col]+" ");
            }
            if (row!=0){
                System.out.printf(arr[(row-1)*rows+col]+" ");
            }
            if (col!=0){
                System.out.printf(arr[row*rows+(col-1)]+" ");
            }
            if (col<cols-1){
                System.out.printf(arr[row*rows+col+1]+" ");
            }
            col+=2;
            System.out.println();
        }
    }
    public static void oushu(int[] arr,int rows,int cols){
        col=cols-1;
        while (col>=0){
            System.out.printf(arr[row*rows+col]+" ");
            if (row<rows-1){
                System.out.printf(arr[(1+row)*rows+col]+" ");
            }
            if (row!=0){
                System.out.printf(arr[(row-1)*rows+col]+" ");
            }
            if (col!=0){
                System.out.printf(arr[row*rows+(col-1)]+" ");
            }
            if (col<cols-1){
                System.out.printf(arr[row*rows+col+1]+" ");
            }
            col-=2;
            System.out.println();
        }





    }
    public static void  travleMatrix(int[] arr,int rows,int cols){
        int count=1;
        int i=1;
        while (count<=rows){
            if (i%2!=0){
                jishu(arr,rows,cols);
                if (row+2<rows){
                    row+=2;
                }else {
                    row++;
                }
                count=row+1;
            }else {
                oushu(arr,rows,cols);
                if (row+2<rows){
                    row+=2;
                }else {
                    row++;
                }
                count=row+1;
            }
            i++;
        }

    }



    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        travleMatrix(arr,4,4);



    }

}
