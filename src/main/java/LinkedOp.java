import java.util.*;

/**
 * @Author: egg
 * @Date: 2019-05-15 10:41
 */
public class LinkedOp {
    /**
     * 将数组转换为链表
     * @param s
     * @return
     */
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
     * 合并两个链表并且去重
     * @param node1
     * @param node2
     * @return
     */
    public ListNode mergeList(ListNode node1,ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1==null){
            return node2;
        }
        if (node2==null){
            return node1;
        }
        if (node1.val<node2.val){
            node1.next=mergeList(node1.next,node2);
            return node1;
        }else if (node2.val<node1.val){
            node2.next=mergeList(node1,node2.next);
            return node2;
        }else {
            node1.next=mergeList(node1.next,node2.next);
            return node1;
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
     * 合并链表非递归
     * @param list1
     * @param list2
     * @return
     */
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

    /**
     * 约瑟夫问题，求最后剩下的数字
     * 用环形链表
     * @param n n个数字
     * @param m 每次剔除m位置的数字
     * @return
     */
    public void lastRemainning(int n,int m){
        //抽出头节点
        ListNode first=new ListNode(1);
        ListNode temp=first;

        //建立单向链表
        for (int i=2;i<=n;i++){
            temp=(temp.next=new ListNode(i));
        }
        //最后一个节点指向第一个节点
        temp.next=first;
        System.out.println("依次出来的顺序为：");
        while(temp!=temp.next)
        {
            for(int i=1;i<m;i++)
            {
                temp=temp.next;
            }
            System.out.print(temp.next.val+" ");
            temp.next=temp.next.next;
        }
        System.out.println();
        System.out.println("最后剩余的是： "+temp.val);
    }

    /**
     * 约瑟夫问题，从0-m-1
     * 当两个均为0时，返回值-1
     * @param n
     * @param m
     * @return
     */
    public int  yueSeFu(int n,int m){
        if(n==0&&m==0){
            return -1;
        }
        ListNode node=new ListNode(0);
        ListNode head=node;
        for (int i=1;i<n;i++){
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
        return head.val;

    }

    /**
     * 确定链表是否有环
     * @param node
     * @return
     */
    public static ListNode meetingNode(ListNode node){
        if (node==null||node.next==null){
            return null;
        }
        //只有两个节点，不成环的那种
        ListNode temp=node.next.next;
        while (temp!=null&&node!=null){
            if (node==temp){
                return node;
            }else {
                node=node.next;
                temp=temp.next;
                if (temp!=null){
                    temp=temp.next;
                }

            }
        }
        return null;
    }
    public ListNode entryNodeOfLoop(ListNode node){
        ListNode meetingNode=meetingNode(node);
        if (meetingNode==null){
            return null;
        }
        //得到环中的数目
        int nodeInLoop=1;
        ListNode pNode1=meetingNode;
        while (pNode1.next!=meetingNode){
            pNode1=pNode1.next;
            nodeInLoop++;
        }
        //找到入口
        pNode1=node;
        for (int i=0;i<nodeInLoop;i++){
            pNode1=pNode1.next;
        }
        ListNode pNode2=node;
        while (pNode1!=pNode2){
            pNode1=pNode1.next;
            pNode2=pNode2.next;
        }
        return pNode1;

    }
    /**
     * 两个链表相加
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null){
            return null;
        }
        List<Integer> list=new ArrayList<Integer>();
        while (l1!=null&&l2!=null){
            int temp=l1.val+l2.val;
            list.add(temp);
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            list.add(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            list.add(l2.val);
            l2=l2.next;
        }
        ListNode node=new ListNode(0);
        ListNode begin=node;
        int addOne=0;
        for (int i:list){
            node.next=new ListNode(0);
            node=node.next;
            int temp=i+addOne;
            addOne=0;
            while (temp>=10){
                addOne++;
                temp-=10;
            }
            node.val=temp;
        }
        if (addOne==1){
            node.next=new ListNode(addOne);
        }

        return begin.next;
    }

    /**
     * 找到两个链表的第一个共同点
     * @param headA
     * @param headB
     * @return
     */
    public  ListNode findFirstComNode(ListNode headA,ListNode headB){
        int lenA=0;
        int lenB=0;
        ListNode tempA=headA;
        ListNode tempB=headB;
        while (tempA!=null){
            tempA=tempA.next;
            lenA++;
        }
        while (tempB!=null){
            tempB=tempB.next;
            lenB++;
        }


        if (lenA>lenB){
            tempA=headA;
            int len=lenA-lenB;
            while (len!=0){
                tempA=tempA.next;
                len--;
            }
        }else if (lenA<lenB){
            tempB=headB;
            int len=lenB-lenA;
            while (len!=0){
                tempB=tempB.next;
                len--;
            }

        }else {
            tempB=headB;
            tempA=headA;
        }
        while (tempA!=null&&tempB!=null){
            if (tempA==tempB){
                return tempA;
            }else {
                tempA=tempA.next;
                tempB=tempB.next;
            }

        }
        return null;

    }


    public static void main(String[] args) {
        LinkedOp op = new LinkedOp();
        int[] data1={1,9,3,8};
        int[] data2={1,9,3,8};
        ListNode head1=op.arrayToListNode(data1);
        ListNode head2=op.arrayToListNode(data2);
        if (head1==head2){
            System.out.println(1);
        }






    }
}
