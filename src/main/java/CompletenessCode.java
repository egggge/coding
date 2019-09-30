/**
 * @Author: egg
 * @Date: 2019-05-13 16:24
 */
public class CompletenessCode {
    /**
     * 正则表达式匹配
     * *表示的是它前面的夫出现任意次（包括0）
     * @param input
     * @param pattern
     * @return
     */
    public static boolean isMatch(String input,String pattern){
        if(input==null||pattern==null) {
            return false;
        }
        return matchCore(input,0,pattern,0);
    }
    private static boolean matchCore(String input,int i,String pattern,int p){
        if((input.length()<=i)&&(pattern.length()<=p)){
            //出口1，input和pattern都到了字符串末尾
            return true;
        }
        if((input.length()>=i+1)&&(pattern.length()<=p)){
            //出口2，字符串input没到到末尾，pattern到末尾
            return false;
        }

        if((input.length()<=i)&&(pattern.length()>=p+1)){
            return true;
        }


//        if (p+1==pattern.length()){
//            if (input.charAt(i)==pattern.charAt(p)||pattern.charAt(p)=='.'){
//                return matchCore(input,i+1,pattern,p+1);
//            }else {
//                return false;
//            }
//        }
        //pattern第二个字符为*
        if(p+2<=pattern.length()&&(pattern.charAt(p+1)=='*')){

            //首字母相匹配

            if((input.charAt(i)==pattern.charAt(p))){

                //*表示出现1次
                return matchCore(input,i+1,pattern,p+2)
                        //*表示出现多次
                        ||matchCore(input,i+1,pattern,p)
                        //*表示出现0次
                        ||matchCore(input,i,pattern,p+2);
            }else if ((pattern.charAt(p)=='.')){
                return matchCore(input,i+1,pattern,p+2)
                        //*表示出现多次
                        ||matchCore(input,i+1,pattern,p+1)
                        //*表示出现0次
                        ||matchCore(input,i,pattern,p+2);
            }
            else{
                //首字母不匹配
                return matchCore(input,i,pattern,p+2);
            }
        }

        if((input.charAt(i)==pattern.charAt(p))||(pattern.charAt(p)=='.')){

            //pattern第二个字母不是*，且首字母匹配
            return matchCore(input,i+1,pattern,p+1);
        }
            return false;  //其余情况全部不匹配
    }
    /**
     * 1.base为0
     * 2。指数小于0
     * 3。乘方的效率
     * @param base
     * @param exponent
     * @return
     */
    public static double power(double base,int exponent){
        boolean invalidInput = false;
        int absExponent = exponent;
        if (base==0.0&&exponent<0){
            invalidInput=true;
            return 0.0;
        }
        if (exponent<0){
            absExponent = -exponent;
        }
        double res = 0.0;
        //res=powerExponent(base,absExponent);
        res=powerExponentOlogn(base,absExponent);
        if (exponent<0){
            res=1.0/res;
        }
        return res;


    }

    public static double powerExponent(double base,int exponent){

        double res=1.0;
        for (int i=0;i<exponent;i++){
            res*=base;

        }


        return res;
    }

    /**
     *
     * @param base
     * @param exponent
     * @return
     */

    public static double powerExponentOlogn(double base,int exponent) {


        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double res = powerExponentOlogn(base, exponent >> 1);
        res *= res;
        //判断是否为奇数，只需要看最后一位是否为1
        if ((exponent & 0x1) == 1) {
            res *= base;

        }
        return res;

//        if (exponent%2==0){
//            if (exponent==2){
//                return base*base;
//            }
//            else {
//                return powerExponent(base,exponent/2)*powerExponent(base,exponent/2);
//
//            }
//
//
//        }
//        else {
//            if (exponent==1){
//                return base;
//            }
//            return powerExponent(base,exponent/2)*powerExponent(base,exponent/2)*base;
//
//        }
    }

        public static void printToMaxOfDigits(int n){
            if (n <= 0) {
                System.out.println("输入的n没有意义");
                return;
            }
            //声明字符数组,用来存放一个大数
            char number[] = new char[n];
            for (int i = 0; i < number.length; ++i) { //放字符0进行初始化
                number[i] = '0';
            }
            while (!incrementNumber(number)) { //如果大数自加，直到自溢退出
                printNumber(number); //打印大数
            }
        }

        private static boolean incrementNumber(char[] number){
            boolean isOverflow = false; //判断是否溢出
            int nTakeOver = 0; //判断是否进位
            int nLength = number.length;
            for (int i = nLength - 1; i >= 0; --i) {
                int nSum = number[i] - '0' + nTakeOver; //取到第i位的字符转换为数字 +进位符
                if (i == nLength - 1) { //末尾自加1
                    ++nSum;
                }
                if (nSum >= 10) {
                    if (i == 0) {
                        isOverflow = true;
                    } else {
                        nSum -= 10;
                        nTakeOver = 1;
                        number[i] = (char) ('0' + nSum);
                    }
                } else {
                    number[i] = (char) (nSum + '0');
                    break;
                }
            }
            return isOverflow;
        }


    private static void printNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            if (isBeginning0 && number[i] != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();

    }








    public static void main(String[] args){
        if (isMatch("aa","a*")){
            System.out.println(1);
        }


    }
}
