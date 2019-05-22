import java.util.Arrays;

/**
 * @Author: egg
 * @Date: 2019-05-15 10:41
 */
public class LinkedOp {
    private static void delectNode(ListNode head,ListNode delnode){
        if (head==null||delnode==null){
            return;
        }
        //delnode不是尾节点
        if (delnode.next!=null){
            ListNode node = delnode.next;
            delnode.val=node.val;
            delnode.next=node.next;

            node.next=null;


        }
        //链表只有一个节点
        else if (head==delnode){
            delnode=null;
            head=null;
        }
        //delnode是尾节点
        else {
            ListNode temp = head;
            while (temp.next!=delnode){
                temp=temp.next;
            }
            temp.next=null;
            delnode=null;

        }

    }

    /**
     * 1.链表为空
     * 2。链表只有一个元素，当最后一个元素处理
     * 3.递归过程
     * 4。思维没有抽象出来
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode merge(ListNode list1,ListNode list2){
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        ListNode temp=null;
        if (list1.val<list2.val){
            temp=list1;
            temp.next=merge(list1.next,list2);
        }
        else {
            temp=list2;
            temp.next=merge(list1.next,list2);
        }
        return temp;

    }
}
