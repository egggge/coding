
import java.util.*;

/**
 * @Author: egg
 * @Date: 2019-04-21 11:03
 */
public class  BinaryTree<E extends Number> {
    private boolean finished=false;
    class TreeNode<E> {
        private E data;
        private TreeNode<E> rchild;
        private TreeNode<E> lchild;

        //构造函数，无参数
        TreeNode(){};

        TreeNode(E e){
            this.data = e;
        }

        TreeNode(E data,TreeNode<E> lchild, TreeNode<E> rchild){
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
        }
        public E getData(){
            return this.data;
        }

        public void setData(E data){
            this.data=data;

        }
        public void setLchild(TreeNode<E> lchild){
            this.lchild = lchild;
        }

        public TreeNode<E> getLchild(){
            return this.lchild;
        }

        public void setRchild(TreeNode<E> rchild){
            this.rchild = rchild;
        }

        public TreeNode<E> getRchild(){
            return this.rchild;
        }



    }
    //根节点

    private TreeNode<E> root;

    //链式存储二叉树节点

    private List<TreeNode> nodeList = null;

    public BinaryTree(){

    }

    public BinaryTree(TreeNode<E> root){
        this.root = root;
    }

    /**
     * 把数组转变成完全二叉树
     * 层次遍历
     * @param array
     * @return
     */

    public TreeNode<E> buildTree(E[] array){
        //这里用arraylist也是一样的
        nodeList = new LinkedList<TreeNode>();
        //首先数组中的数字化为二叉树的节点
        for (int i=0;i<array.length;i++){
            nodeList.add(new TreeNode(array[i]));
        }
        //左孩子：2*j+1
        //右孩子：2*j+2
        //注意j的取值
        //节点从0开始计算
        for (int j=0;j<(array.length/2-1);j++){
            nodeList.get(j).setLchild(nodeList.get(2*j+1));
            nodeList.get(j).setRchild(nodeList.get(2*j+2));
        }

        //最后一个父节点，单独处理
        int index = array.length/2-1;
        nodeList.get(index).setLchild(nodeList.get(2*index+1));
        //如果长度是奇数才有右孩子
        if (array.length%2!=0){
            nodeList.get(index).setRchild(nodeList.get(2*index+2));
        }
        root = nodeList.get(0);
        return root;


    }
    /**
     * 递归求解树的高度
     * @param node
     * @return
     */

    public int getHigh(TreeNode<E> node){
        if (node==null){
            return 0;
        }
        else {
            int i = getHigh(node.getLchild());
            int j = getHigh(node.getRchild());
            return (i<j)?(j+1):(i+1);
        }
    }
    /**
     * 递归求解树的节点数
     * @param node
     * @return
     */

    public int getNodes(TreeNode<E> node){
        if (node==null){
            return 0;
        }
        else {
            return 1+getNodes(node.getLchild())+getNodes(node.getRchild());
        }

    }

    /**
     * 中序遍历，左-》根-》右
     * 递归实现
     * 同理，前序和后序
     */
    public void LNR(TreeNode<E> node){
        if (node==null){
            return;
        }
        else {
            LNR(node.getLchild());
            System.out.println(node.data);
            LNR(node.getRchild());
        }


    }

    /**
     * 前序遍历
     * @param node
     */
    public void NLR(TreeNode<E> node){
        if (node==null){
            return;
        }else {
            System.out.println(node.data);
            NLR(node.getLchild());
            NLR(node.getRchild());
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    public void LRN(TreeNode<E> node){
        if (node==null){
            return;
        }else {
            LRN(node.getLchild());
            LRN(node.getRchild());
            System.out.println(node.data);
        }
    }

    /**
     * 先把根结点压入栈，然后找到左节点
     * 左子树为空，出栈（相当于一个根结点），找寻出栈节点的右节点
     * 非递归实现中序遍历
     * @param node
     */
    public void nonRecInOrder(TreeNode<E> node){
        Stack<TreeNode<E>> nodeStack = new Stack<TreeNode<E>>();
        TreeNode<E> nodeTemp = node;
        //栈非空
        while(nodeTemp != null || !nodeStack.isEmpty()){
            //先遍历左子树，把根节点压栈
            if(nodeTemp != null){
                nodeStack.push(nodeTemp);
                nodeTemp = nodeTemp.getLchild();
            }else{
                //左子树为空
                nodeTemp = nodeStack.pop();
                System.out.print(nodeTemp.getData() +" ");
                nodeTemp = nodeTemp.getRchild();
            }
        }
    }

    /**
     * 非递归后序遍历
     * 栈：先进后出
     * 用双栈
     * @param node
     */
    public void nonRecLastOrder(TreeNode<E> node){
        Stack<TreeNode<E>> nodeStack = new Stack<TreeNode<E>>();
        Stack<TreeNode<E>> nodeStack2 = new Stack<TreeNode<E>>();

        TreeNode<E> nodeTemp=node;
        if (node!=null){
            nodeStack.push(node);
        }
        while(!nodeStack.isEmpty()){
            nodeTemp = nodeStack.pop();
            nodeStack2.push(nodeTemp);
            if(nodeTemp.getLchild()!= null){
                nodeStack.push(nodeTemp.getLchild());
            }
            if(nodeTemp.getRchild()!= null){
                nodeStack.push(nodeTemp.getRchild());
            }
        }
        while(!nodeStack2.isEmpty()){
            System.out.println(nodeStack2.pop().data+ " ");
        }
    }



    /**
     * 非递归实现前序遍历
     * @param node
     */

    protected void nonRecPreOrder(TreeNode<E> node){
        Stack<TreeNode<E>> nodeStack = new Stack<TreeNode<E>>();
        TreeNode<E> nodetemp = node;
        while(nodetemp != null || !nodeStack.isEmpty()){
            //找到根节点
            if(nodetemp != null){
                System.out.println(nodetemp.getData()+" ");
                nodeStack.push(nodetemp);
                nodetemp = nodetemp.getLchild();
            }else{
                //左子树为空
                nodetemp = nodeStack.pop();
                nodetemp = nodetemp.getRchild();
            }
        }

    }

    /**
     * 层次遍历，用队列
     * @param node
     */

    public void levelOrder(TreeNode<E> node){
        Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
        //根节点入队
        queue.offer(node);
        while ( !queue.isEmpty()){
            TreeNode<E> nodetemp = queue.poll();
            System.out.println(nodetemp.getData()+" ");
            if (nodetemp.getLchild()!=null){
                queue.offer(nodetemp.getLchild());
            }
            if (nodetemp.getRchild()!=null){
                queue.offer(nodetemp.getRchild());
            }

        }
    }

    /**
     * 分层打印二叉树
     * 借助两个变量：nextLevle记录这一层有几个节点，toBePrint记录打印了几个节点
     * @param node
     */
    public void printLevel(TreeNode<E> node){
        //这里为什么不能用arraylist
            Queue<TreeNode<E>> queue=new LinkedList<TreeNode<E>>();
            if (node==null){
                return;
            }
            int nextLevel=0;
            int toBePrint=1;
            queue.offer(node);
            while (!queue.isEmpty()){
                TreeNode<E> nodetemp = queue.poll();
                System.out.printf(nodetemp.getData()+" ");
                --toBePrint;
                if (nodetemp.getLchild()!=null){
                    queue.offer(nodetemp.lchild);
                    nextLevel++;
                }
                if (nodetemp.getRchild()!=null){
                    queue.offer(nodetemp.rchild);
                    nextLevel++;
                }
                if (toBePrint==0){
                    System.out.println();
                    toBePrint=nextLevel;
                    nextLevel=0;
                }
            }
    }

    public void zPrint(TreeNode node){
        if (node==null){
            return;
        }
        Stack<TreeNode<E>> stack1=new Stack<TreeNode<E>>();
        Stack<TreeNode<E>> stack2=new Stack<TreeNode<E>>();
        stack1.push(node);

        while (!stack1.empty()||!stack2.empty()){
            while (!stack1.empty()){
                TreeNode<E> nodetemp = stack1.pop();
                System.out.printf(nodetemp.getData()+" ");
                if (nodetemp.getLchild()!=null){
                    stack2.push(nodetemp.lchild);
                }
                if (nodetemp.getRchild()!=null){
                    stack2.push(nodetemp.rchild);
                }
            }
            System.out.println();
            while (!stack2.empty()){
                TreeNode<E> nodetemp = stack2.pop();
                System.out.printf(nodetemp.getData()+" ");
                if (nodetemp.getRchild()!=null){
                    stack1.push(nodetemp.rchild);
                }
                if (nodetemp.getLchild()!=null){
                    stack1.push(nodetemp.lchild);
                }

            }
            System.out.println();


        }


    }

    /**
     * 在二叉树中找到值为m的路径
     * 先序遍历
     * @param root
     * @param k
     */
    public void findPath(TreeNode<E> root,int k){
        if(root == null){
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        findPath(root,k,stack);
    }
    public void findPath(TreeNode<E> root,int k,Stack<Integer> path){
        if(root == null){return;}
        if(root.getLchild() == null && root.getRchild() == null){
            if(root.data.intValue() == k){
                System.out.println("路径开始");
                for(int i :path){
                    System.out.print(i+",");
                }
                System.out.print(root.data.intValue());
            }
        }
        else{
            path.push(root.data.intValue());
            findPath(root.getLchild(),k-root.data.intValue(),path);
            findPath(root.getRchild(),k-root.data.intValue(),path);
            //在返回父节点之前，在路径上删除当前节点
            path.pop();
        }
    }

    public TreeNode<E> convert(TreeNode<E> root){
        TreeNode<E> pLastNodeList = null;
        convertNode(root,pLastNodeList);

        TreeNode<E> pHeadOfList = pLastNodeList;
        while (pHeadOfList!=null&&pHeadOfList.lchild!=null){
            pHeadOfList=pHeadOfList.lchild;
        }
        return pHeadOfList;

    }

    /**
     *
     * @param pNode
     * @param pLastNodeInList 双向链表的尾节点
     */
    public void convertNode(TreeNode<E> pNode,TreeNode<E> pLastNodeInList){
        if (pNode==null){
            return;
        }
        TreeNode<E> pCurrent = pNode;
        if (pCurrent.getLchild()!=null){
            convertNode(pCurrent.getLchild(),pLastNodeInList);
        }
        pCurrent.lchild=pLastNodeInList;
        if (pLastNodeInList!=null){
            pLastNodeInList.rchild=pCurrent;
        }
        pLastNodeInList=pCurrent;
        if (pCurrent.rchild!=null){
            convertNode(pCurrent.rchild,pLastNodeInList);
        }
    }

    /**
     * 堆排序
     * 1.构造大顶堆
     * 2.交换元素，再构造大顶堆
     * @param arr
     */

    public static void sort(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            //将堆顶元素与末尾元素进行交换
            swap(arr,0,j);
            //重新对堆进行调整
            adjustHeap(arr,0,j);
        }

    }
    public static void adjustHeap(int []arr,int i,int length){
        //先取出当前元素i
        int temp = arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        //k代表每个非叶子节点的左节点
        for(int k=i*2+1;k<length;k=k*2+1){
            //不是用根节点与左右子节点比较，而是左右子节点先比较，选出最大
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if(arr[k] >temp){
                arr[i] = arr[k];
                //因为k不一定到了最后一个节点
                i = k;
            }else{
                break;
            }
        }
        //将temp值放到最终的位置
        arr[i] = temp;
    }
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 根据前序和中序遍历重构二叉树
     * @param pre
     * @param in
     * @return
     */
    public  TreeNode<E> reBuild(int[] pre,int[] in){
        TreeNode root=reBuild(pre,0,pre.length-1,in,0,in.length-1);
        return root;

    }

    /**
     * 递归生成二叉树的逐个左右子树的根节点
     * @param pre
     * @param startPre
     * @param endPre
     * @param in
     * @param startIn
     * @param endIn
     * @return
     */
    public  TreeNode<E> reBuild(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        if (startPre>endPre||startIn>endIn){
            return null;
        }
        //首先确定根结点：前序的第一个节点
        TreeNode root=new TreeNode(pre[startPre]);
        //开始遍历中序数组，确定根结点的位置，将中序分为两个部分
        for (int i=startIn;i<=endIn;i++){
            if (in[i]==pre[startPre]){
                root.lchild=reBuild(pre,startPre+1,startPre+(i-startIn),in,startIn,i-1);
                root.rchild=reBuild(pre,(i-startIn+startPre)+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }


    /**
     * 树的子结构
     * @param root1
     * @param root2
     * @return
     */
    public boolean hasSubTree(TreeNode<E> root1,TreeNode<E> root2){
        if (root1==null||root2==null){
            return false;
        }
        boolean isSubTree=false;
        //找到一个相同的根节点，进入检查子结构部分
        if (root1.data.equals(root2.data)){
            isSubTree=isSubTree(root1,root2);
        }
        if (!isSubTree){
            isSubTree=hasSubTree(root1.rchild,root2);
        }
        if (!isSubTree){
            isSubTree=hasSubTree(root1.lchild,root2);
        }
        return isSubTree;

    }
    public boolean isSubTree(TreeNode<E> root1,TreeNode<E> root2){
        //子树遍历完
        if (root2==null){
            return true;
        }
        //大树遍历完
        if (root1==null){
            return false;
        }
        if (root1.data.equals(root2.data)){
            return isSubTree(root1.lchild,root2.lchild)&&isSubTree(root1.rchild,root2.rchild);
        }
        return false;
    }



    public static void main(String[] args){

        BinaryTree bt = new BinaryTree();
        Number[] array={0,1,2,3,4,5,6,7};
        BinaryTree.TreeNode root = bt.buildTree(array);
        //bt.nonRecLastOrder(root);

        //bt.printLevel(root);
       bt.zPrint(root);
//       // bt.LNR(root);
//        //bt.nonRecInOrder(root);
//        //bt.levelOrder(root);
//        //bt.findPath(root,22);
//        bt.convert(root);
//
    }





}
