import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: egg
 * @Date: 2019-05-15 10:41
 */
public class LinkedOp {
    public ListNode arrayToListNode(int[] s) {
        ListNode root = new ListNode(s[0]);
        ListNode other = root;
        for (int i = 1; i < s.length; i++) {
            ListNode temp = new ListNode(s[i]);
            other.next = temp;
            other = temp;
        }
        return root;
    }

    /**
     * 从尾打印链表
     * @param head
     */
    public void printFromTail(ListNode head){
        Stack<Integer> stack = new Stack<Integer>();
        while (head!=null){
            stack.push(head.val);
        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }

    }

    /**
     * 删除链表节点
     * @param head
     * @param delnode
     */
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
     * 合并两个有序链表
     * 1.链表为空
     * 2。链表只有一个元素，当最后一个元素处理
     * 3.递归过程
     * 4。思维没有抽象出来
     * @param list1
     * @param list2
     * @return
     */
    public  ListNode merge(ListNode list1,ListNode list2){
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        if (list1.val<=list2.val){
            list1.next=merge(list1.next,list2);
            return list1;
        }
        else {
            list2.next=merge(list1,list2.next);
            return list2;
        }


    }
    public  ListNode mergeNoRecursion(ListNode list1,ListNode list2){
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        ListNode head=new ListNode(-1);
        ListNode pNode=head;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                pNode.next=list1;
                list1=list1.next;
                pNode=pNode.next;
            }else {
                pNode.next=list2;
                list2=list2.next;
                pNode=pNode.next;
            }
        }
        if (list2!=null){
            list1=list2;

        }
        pNode.next=list1;
        return head.next;


    }

    /**
     * 反转链表：每次只转一次方向，然后更新前节点和当前节点
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode pReverseHead=null;
        ListNode pNode=head;
        ListNode pPrev=null;
        while (pNode!=null){
            ListNode pNext=pNode.next;
            //遍历到最后一个节点，保存反转后头节点
            if (pNext==null){
                pReverseHead=pNode;
            }
            pNode.next=pPrev;
            pPrev=pNode;
            pNode=pNext;
        }
        return pReverseHead;

    }

    public static void main(String[] args) {
        LinkedOp op = new LinkedOp();
        int[] data1={1,3};
        ListNode head1=op.arrayToListNode(data1);
        int[] data2={2,4,6};
        ListNode head2=op.arrayToListNode(data2);
        ListNode res=op.mergeNoRecursion(head2,head1);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }


    }
}
