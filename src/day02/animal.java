package day02;

public class animal {
    //需要调用成员变量
    public animal(int age){
        this.age = age;
    }

    //引用上面的animal方法
    public animal(String type){
        //引用带参数的方法，同时赋了初值
        this(1);
        this.type = type;
    }

    public void setAge(){
        //this在这里提示是该类的
        this.age = age + 1;
    }

    public animal(String a,int b){
        type = a;
        age = b;

    }
    public String type;
    private int age;

    public void getinfo(){
        System.out.println(type);
        System.out.println(age);
    }

//    public int getAge(){
//        return age;
//    }
//
//    public void setAge(int i){
//        if (i >= 0 && i < 120){
//            age = i;
//        }else System.out.println("越界");
//    }
}
