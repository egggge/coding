package BaseJava;

/**
 * @Author: egg
 * @Date: 2019-06-25 11:41
 */
public class Animal {
    void eat() {
        System.out.println("animal : eat");
    }
    void play(){
        System.out.println("animal : play");
    }
}
class Dog extends Animal {
    @Override
    void eat() {
        //super.eat();//调用父类的方法
        System.out.println("dog : eat");
    }
    void eatTest(int a,long b) {
        super.eat();  // super 调用父类方法
        this.eat();   // this 调用自己的方法
    }
    void eaTest(int a,long b){

    }
}
