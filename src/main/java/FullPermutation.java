import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chendan
 * @date 2019/6/27 8:43
 */
public class FullPermutation {
    private int n;

    public FullPermutation ()
    {
        this.n=0;
    }

    /**
     * 对数字进行排列组合
     * @param candidate
     * @param prefix
     */
    public  void listAll(List candidate, String prefix)
    {
        if(candidate.isEmpty())
        {
            System.out.println(prefix);
            n++;


        }else {
            for(int i=0;i<candidate.size();i++)
            {
                //转换成linkList,移除一个对象是在不影响原来队列的基础上的
                List temp=new LinkedList(candidate);
                //用于保存排列组合生成的结果
                String s1=prefix+temp.remove(i);
                //注意，这里temp和s1都是全新的集合和字符串，并不是一直对一个集合来进行操作
                //递归过程
                listAll(temp,s1);
            }

        }

    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public static void main(String[] args) {
        String []arr={"1","3","2"};
        FullPermutation f=new FullPermutation();
        f.listAll(Arrays.asList(arr),"");
        System.out.println("所有的排列个数："+f.getN());
    }


}
