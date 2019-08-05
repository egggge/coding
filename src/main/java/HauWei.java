import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author chendan
 * @date 2019/8/3 20:41
 */
public class HauWei {
    /**
     * 键值对排序，学会用treemap(类)
     */
    public void pairNumSort(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int len=Integer.parseInt(sc.nextLine());
            TreeMap<Integer,Integer> map=new TreeMap<Integer, Integer>();
            for (int i=len;i>0;i--){
                String s=sc.nextLine();
                int key=Integer.parseInt(s.split(" ")[0]);
                int value=Integer.parseInt(s.split(" ")[1]);
                if(!map.containsKey(key)){
                    map.put(key,value);
                }else{
                    int temp=map.get(key)+value;
                    map.put(key,temp);
                }
            }
            StringBuilder builder = new StringBuilder();
            for(SortedMap.Entry<Integer,Integer>e:map.entrySet()){
                builder.append(e.getKey()).append(" ").append(e.getValue()).append("\r");
            }
            System.out.println(builder.toString());


        }
    }
}
