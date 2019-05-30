import java.util.*;

/**
 * @author chendan
 * @date 2019/5/30 11:09
 */
public class FirstNotRepeating {
    public char firstNotRepeating(String s){
        long startTime = System.currentTimeMillis();
        if (s==null){
            return '\0';
        }
        char[] chars=s.toCharArray();
        HashMap<Character,Integer> hashMap=new HashMap<Character, Integer>();
        for (int i=0;i<chars.length;i++){
            if (!hashMap.containsKey(chars[i])){
                hashMap.put(chars[i],i);
            }
            else {
                hashMap.remove(chars[i]);
            }
        }
        List<Map.Entry<Character,Integer>> mapList = new ArrayList<Map.Entry<Character,Integer>>(hashMap.entrySet());
        Collections.sort(mapList , new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
    });
        long endTime = System.currentTimeMillis();
        System.out.println("程序1运行时间：" + (endTime - startTime) + "ms");
        return mapList.get(0).getKey();
    }
    public char firstNotRepeatingII(String s){
        long startTime = System.currentTimeMillis();
        if (s==null){
            return '\0';
        }
        char[] chars=s.toCharArray();
        HashMap<Character,Integer> hashMap=new HashMap<Character, Integer>();
        for (int i=0;i<chars.length;i++){
            int temp=0;
            if (!hashMap.containsKey(chars[i])){
                temp=1;
            }
            else {
                temp=hashMap.get(chars[i]);
               temp++;

            }
            hashMap.put(chars[i],temp);
        }
        for (int i=0;i<chars.length;i++) {
            if (hashMap.get(chars[i]) == 1) {
                long endTime = System.currentTimeMillis();
                System.out.println("程序2运行时间：" + (endTime - startTime) + "ms");
                return chars[i];
            }

        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("程序2运行时间：" + (endTime - startTime) + "ms");
        return '\0';

    }

    public static void main(String[] args) {
        String s="abaccdeff";
        FirstNotRepeating firstNotRepeating=new FirstNotRepeating();
        System.out.println(firstNotRepeating.firstNotRepeating(s));
        System.out.println(firstNotRepeating.firstNotRepeatingII(s));
    }

}
