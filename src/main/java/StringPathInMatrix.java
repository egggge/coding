/**
 * @Author: egg
 * @Date: 2019-05-06 10:23
 */

// 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
// 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
// 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
// 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
// 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
// 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
// A B T G
// C F C S
// J D E H

/**
 * 首先对所整个矩阵遍历，找到第一个字符，然后向上下左右查找下一个字符，
 * 由于每个字符都是相同的判断方法（先判断当前字符是否相等，再向四周查找），因此采用递归函数。
 * 由于字符查找过后不能重复进入，所以还要定义一个与字符矩阵大小相同的布尔值矩阵，进入过的格子标记为true。
 * 如果不满足的情况下，需要进行回溯，此时，要将当前位置的布尔值标记回false。
 * （所谓的回溯无非就是对使用过的字符进行标记和处理后的去标记）
 */
public class StringPathInMatrix {
    public boolean hasPath(char[] matrix,int rows,int cols,char[] str){
        if (matrix==null||rows<1||cols<1||str==null){
            return false;

        }
        //初始化boolean矩阵
        boolean[] visited = new boolean[rows*cols];
        for (boolean v:visited){
            v=false;
        }

        int pathLength=0;
        //行和列都从0开始
        for (int row=0;row<rows;row++){
            for (int col=0;col<cols;col++){
                if (hasPathCore(matrix,rows,cols,row,col,str,pathLength,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPathCore(char[] matrix,int rows,int cols,int row,int col,char[] str,int pathLength,boolean visited[]){
        //这里就包含了边界的情况
        if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row * cols + col] == true
                || str[pathLength] != matrix[row * cols + col])
        {return false;}
        //字符串对应完毕，函数结束
        if (pathLength==str.length-1){
            return true;
        }
        boolean hasPath = false;
        visited[row*cols+col]=true;
        hasPath=hasPathCore(matrix,rows,cols,row,col-1,str,pathLength+1,visited)
                    ||hasPathCore(matrix,rows,cols,row-1,col,str,pathLength+1,visited)
                    ||hasPathCore(matrix,rows,cols,row+1,col,str,pathLength+1,visited)
                    ||hasPathCore(matrix,rows,cols,row,col+1,str,pathLength+1,visited);
        if (!hasPath){
                --pathLength;
                visited[row*cols+col]=false;
            }

        return hasPath;
    }
    // =======测试代码========

    // A B T G
    // C F C S
    // J D E H

    // BFCTB
    public void test1() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "BFCTB".toCharArray();
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test1 passed.");
        else
            System.out.println("Test1 failed.");
    }

    // A B T G
    // C F C S
    // J D E H

    // BFCE
    public void test2() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "BFCE".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test2 passed.");
        else
            System.out.println("Test2 failed.");
    }

    // matrix=null
    public void test3() {
        char[] matrix = null;
        int rows = 0;
        int cols = 0;
        char[] str = "BFCE".toCharArray();
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test3 passed.");
        else
            System.out.println("Test3 failed.");
    }

    // str=null
    public void test4() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = null;
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test4 passed.");
        else
            System.out.println("Test4 failed.");
    }

    // A

    // A
    public void test5() {
        char[] matrix = "A".toCharArray();
        int rows = 1;
        int cols = 1;
        char[] str = "A".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test5 passed.");
        else
            System.out.println("Test5 failed.");
    }

    // A

    // B
    public void test6() {
        char[] matrix = "A".toCharArray();
        int rows = 1;
        int cols = 1;
        char[] str = "B".toCharArray();
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test6 passed.");
        else
            System.out.println("Test6 failed.");
    }

    public void test7() {
        char[] matrix = "AAAAAAAAAAAA".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "AAAAAAAAAAAA".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test7 passed.");
        else
            System.out.println("Test7 failed.");
    }
    /**
     * 从左下角开始寻找
     * 递归
     * @param arr
     * @param rows
     * @param cols
     * @return
     */
    public static boolean findNum(int[] arr,int rows,int cols,int row,int col,int target){
        if (col>=0&&row>=0&&col<cols&&row<rows){
            if (target==arr[row*rows+col]){
                return true;
            }else if (target>arr[row*rows+col]){
                return findNum(arr,rows,cols,row,col+1,target);
            }else if (target<arr[row*rows+col]){
                return findNum(arr,rows,cols,row-1,col,target);
            }
        }
        return false;
    }
    public static boolean findNum2(int[] arr,int rows,int cols,int target){
        if (arr.length!=0&&rows>0&&cols>0){
            int row=0;
            int col=cols-1;
            while (row<rows&&col>=0){
                if (arr[row*rows+col]==target){
                    return true;
                }else if (arr[row*rows+col]<target){
                    col--;
                }else {
                    row++;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        StringPathInMatrix demo = new StringPathInMatrix();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }

}
