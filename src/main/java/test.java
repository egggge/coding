import java.util.*;

/**
 * @Author: egg
 * @Date: 2019-06-04 20:56
 */
public class test {
    public static int lastWordLen(String s) {
        if (s == null) {
            return 0;
        } else if (s.trim().equals("")) {
            return 0;
        } else {
            String[] l = s.split(" ");
            return l[l.length - 1].toCharArray().length;
        }

    }

    public static int containWord(String s1, String s2) {
        char[] s = s1.toCharArray();
        char[] target = s2.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == target[0]) {
                count++;
            }
        }
        return count;

    }


    public static void sortAscend(Integer[] a) {
        Arrays.sort(a, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        });
    }



    public static String getItoR(String target, List<String> I){
        StringBuffer result=new StringBuffer();
        StringBuffer res=new StringBuffer();
        int temp=0;
        for (int s=0;s<I.size();s++){
            if (I.get(s).contains(target)){
                res.append(s);
                res.append(" ");
                res.append(I.get(s));
                res.append(" ");
                temp=temp+2;
            }
        }
        if (temp!=0){
            result.append(target);
            result.append(" ");
            result.append(temp);
            result.append(" ");
            result.append(res.toString());
            result.append(" ");
        }

        return result.toString();


    }


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            Set<Integer> R=new TreeSet<Integer>();
            List<String> I=new ArrayList<String>();
            String inputI=sc.nextLine();
            String inputR=sc.nextLine();
            int i=Integer.parseInt(inputI.split(" ")[0]);
            int m=1;
            while (m<=i){
                I.add(String.valueOf(inputI.split(" ")[m]));
                m++;
            }
            int j=Integer.parseInt(inputR.split(" ")[0]);
            int n=1;
            while (n<=j){
                R.add(Integer.parseInt(inputR.split(" ")[n]));
                n++;
            }
            int count=0;
            StringBuffer buffer=new StringBuffer();
            int postionR=0;
            while(postionR<j){
                if (!R.(postionR).equals(R.get(postionR+1))){
                    String target=String.valueOf(R.get(postionR));
                    if (getItoR(target,I).length()!=0){
                        int temp=Integer.parseInt(getItoR(target,I).split(" ")[1]);
                        buffer.append(getItoR(target,I));
                        count+=temp+2;

                    }
                    postionR++;
                }else {
                    while (postionR<j-1&&R.get(postionR).equals(R.get(postionR+1))){
                        postionR++;
                    }
                    String target=String.valueOf(R.get(postionR));
                    if (getItoR(target,I).length()!=0){
                        int temp=Integer.parseInt(getItoR(target,I).split(" ")[1]);
                        buffer.append(getItoR(target,I));
                        count+=temp+2;

                    }
                    postionR=postionR+1;

                }
            }
            System.out.printf(count+" "+buffer.toString());

        }

    }
}










