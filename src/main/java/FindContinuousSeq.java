/**
 * @author chendan
 * @date 2019/6/18 11:21
 */
public class FindContinuousSeq {
    public void findContinuousSeq(int target){
        int small=1;
        int middle=(1+target)/2;
        int big=2;
        int curTarget=small+big;
        if (target<=3){
            throw new RuntimeException();
        }
        while (small<middle){
            if (curTarget==target){
                printContinuousSeq(small,big);
                System.out.println();
            }
            while (curTarget>target&&small<middle){
                curTarget-=small;
                small++;
                if (curTarget==target){
                    printContinuousSeq(small,big);
                    System.out.println();
                }
            }
            big++;
            curTarget+=big;
        }
    }
    public void printContinuousSeq(int begin,int end){
        for (int i=begin;i<=end;i++){
            System.out.printf(i+" ");
        }
    }

    public static void main(String[] args) {
        FindContinuousSeq findContinuousSeq=new FindContinuousSeq();
        findContinuousSeq.findContinuousSeq(16);
    }
}
