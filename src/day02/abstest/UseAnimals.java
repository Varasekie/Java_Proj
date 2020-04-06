package day02.abstest;

public class UseAnimals {
    public void useAnimal(Animal animal){
        System.out.println("是一个使用抽象类作形参的函数");
    }

    public Animal getAnimal(){
        //抽象类不能直接创建对象，只能用其子类多态的形式
        Animal a = new Cat();
        return a;
    }
}
