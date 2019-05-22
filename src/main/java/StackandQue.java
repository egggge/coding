import java.util.Stack;

/**
 * @Author: egg
 * @Date: 2019-05-05 10:29
 */
public class StackandQue {
    //尝试用抽象类来完成
    class stackToQue {
        public Stack<Integer> stack1 = new Stack();
        public Stack<Integer> stack2 = new Stack();


        public  void appendTail(int num) {
            stack1.push(num);

        }

        public int deleteHead() {
            if (stack2.empty()){
                while (!stack1.empty()){
                    stack2.push(stack1.peek());
                }
            }
            if (stack2.empty()){
                System.out.println("quene is empty");
            }
            return stack2.peek();
        }
    }

    public static void main(String[] args){
        StackandQue stackandQue = new StackandQue();
        StackandQue.stackToQue stackToQue = stackandQue.new stackToQue();


    }
}
