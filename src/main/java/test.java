import java.util.*;

/**
 * @Author: egg
 * @Date: 2019-06-04 20:56
 */
public class test {
    public static void yueSeFu(int n,int m){
        ListNode node=new ListNode(1);
        ListNode head=node;
        for (int i=2;i<=n;i++){
            node.next=new ListNode(i);
            node=node.next;
        }
        //形成一个环
        node.next=head;
        int count=1;


        while (head.next!=head){
            while ((m-count)!=1){
                head=head.next;
                count++;
            }
            System.out.println(head.next.val);
            if (head.next!=null){
                head.next=head.next.next;
                head=head.next;
                count=1;

            }


        }
        System.out.println(head.val);;



    }
    public static void sortAscend(Integer[] a){
        Arrays.sort(a, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        });
    }





    public static void main(String[] args) {
//        Integer[] arr={1,4,6,2,3,4};
//        sortAscend(arr);
//        for (int i:arr){
//            System.out.println(i);
//        }
        yueSeFu(10,3);





    }






    }



