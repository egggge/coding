import java.util.*;

/**
 * @Author: egg
 * @Date: 2019-06-04 20:56
 */
public class test {







    public static void sortAscend(Integer[] a) {
        Arrays.sort(a, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        });
    }




    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String[] arr=sc.nextLine().split(" ");
            List<String> output=new ArrayList<String>();
            int n=Integer.parseInt(arr[0]);
            for (int i=1;i<=n;i++){
                StringBuffer s=new StringBuffer();
                int l=arr[i].length();
                int record=l/8;
                int remind=l%8;
                int k=0;
                while (record>=1){
                    output.add(arr[i].substring(k,k+8));
                   // System.out.println(arr[i].substring(k,k+8));
                    record--;
                    k=+8;
                }
                if (remind!=0){
                    String temp=arr[i].substring(k,l);
                    s.append(temp+"00000000");
                    output.add(s.toString().substring(0,8));
                    //System.out.println(s.toString().substring(0,8));
                }
                }
            Collections.sort(output);
            for (String p:output){
                System.out.println(p);
                //System.out.printf(p+" ");
            }
            }

        }







    }













